package com.example.graphql.demographql;
import io.aexp.nodes.graphql.annotations.GraphQLProperty;
import io.aexp.nodes.graphql.annotations.GraphQLArgument;
import io.aexp.nodes.graphql.annotations.GraphQLArguments;

@GraphQLProperty(name="createToken", arguments={@GraphQLArgument(name="login"), @GraphQLArgument(name="password")} )
public class TesteGraphql {
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}