package st.malike.elasticsearch.oauth2.plugin;

import org.elasticsearch.cluster.metadata.IndexNameExpressionResolver;
import org.elasticsearch.cluster.node.DiscoveryNodes;
import org.elasticsearch.common.settings.ClusterSettings;
import org.elasticsearch.common.settings.IndexScopedSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.SettingsFilter;
import org.elasticsearch.common.util.concurrent.ThreadContext;
import org.elasticsearch.plugins.*;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestHandler;
import org.elasticsearch.rest.action.RestActions;
import st.malike.elasticsearch.oauth2.plugin.service.OAuth2TokenService;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * @author malike_st
 */
public class ElasticOAuth2Plugin extends Plugin implements ScriptPlugin, ActionPlugin, IngestPlugin, NetworkPlugin {


    @Override
    public UnaryOperator<RestHandler> getRestHandlerWrapper(ThreadContext threadContext) {
        return (RestHandler r) -> (RestHandler) (request, channel, client) -> {
            String tokenId ="";
            if(threadContext.getHeaders().containsKey("Authorization")){
                tokenId = threadContext.getHeader("Authorization").trim().replace("Bearer","");
                if(new OAuth2TokenService().validateAndCheckAuthorityToken(tokenId,r.getClass().getName())) {
                    r.handleRequest(request, channel, client);
                }
            }
            throw new Exception("");
        };
    }




    }
