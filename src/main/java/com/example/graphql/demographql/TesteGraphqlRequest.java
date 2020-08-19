package com.example.graphql.demographql;

import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author Tron
 */
public class TesteGraphqlRequest {
    
    @ApiModelProperty(notes="Login")
    private String login;
    
    @ApiModelProperty(notes="Senha")
    private String senha;
    
    public TesteGraphqlRequest() {
    }

    public String getLogin() {
      return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
