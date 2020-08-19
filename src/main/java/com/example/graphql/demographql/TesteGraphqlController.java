package com.example.graphql.demographql;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import io.aexp.nodes.graphql.*;

@RestController
@RequestMapping("/api")
@Api(description = "Testando consumo de graphql")
@CrossOrigin(origins = "*")
public class TesteGraphqlController {

    private static Logger logger = LoggerFactory.getLogger(TesteGraphqlController.class);

    RestTemplate rest;

    public TesteGraphqlController(RestTemplateBuilder builder) {
        this.rest = builder.build();
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/teste", consumes = "application/json", method = RequestMethod.POST)
    @ApiOperation(value = "Teste com graphql")
    public ResponseEntity<Object> teste(@RequestBody TesteGraphqlRequest request) {
        logger.info("[REQUEST]: " + request.getLogin());
        logger.info("[REQUEST]: " + request.getSenha());

        try {
          GraphQLTemplate graphQLTemplate = new GraphQLTemplate();
          
          GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
          .url("https://url.graph")
          .request(TesteGraphql.class)
          .arguments(new Arguments("createToken",
            new Argument("login", request.getLogin()),
            new Argument("password", request.getSenha())
          ))
          .build();

          GraphQLResponseEntity<TesteGraphql> responseEntity = graphQLTemplate.mutate(requestEntity, TesteGraphql.class);

          return new ResponseEntity<>(responseEntity.getResponse(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("[ERROR]: " + ex);
            return new ResponseEntity<>("eita", HttpStatus.BAD_REQUEST);
        }

    }
}
