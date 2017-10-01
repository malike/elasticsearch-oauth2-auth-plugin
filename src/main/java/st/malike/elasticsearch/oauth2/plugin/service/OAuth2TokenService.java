package st.malike.elasticsearch.oauth2.plugin.service;

import st.malike.elasticsearch.oauth2.plugin.exception.AuthenticationException;
import st.malike.elasticsearch.oauth2.plugin.exception.InsufficientPriviledgeException;

/**
 * @author malike_st
 */
public class OAuth2TokenService {

    public boolean validateAndCheckAuthorityToken(String tokenId,String action) throws AuthenticationException,
            InsufficientPriviledgeException{
        return  false;
    }
}
