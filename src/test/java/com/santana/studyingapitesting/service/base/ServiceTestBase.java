package com.santana.studyingapitesting.service.base;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;

public class ServiceTestBase {
    private static String secretName = "dev/...";

    public static String username;
    public static String password;

    @BeforeAll
    public static void setup() {
        var client = SecretsManagerClient.builder().region(Region.US_EAST_1).build();
        var secrets = client.getSecretValue(GetSecretValueRequest.builder().secretId(secretName).build());

        username = JsonPath.read(secrets.secretString(), "$.username");
        password = JsonPath.read(secrets.secretString(), "$.password");
    }
}
