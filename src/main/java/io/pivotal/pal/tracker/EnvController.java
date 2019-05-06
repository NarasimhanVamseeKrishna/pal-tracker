package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private Map<String, String> env = new HashMap<>();

    public EnvController(@Value("${cf.instance.port:NOT SET}")String port,
                        @Value("${cf.instance.memory.limit:NOT SET}") String memLimit,
                         @Value("${cf.instance.index:NOT SET}") String instanceIndx,
                         @Value("${cf.instance.addr:NOT SET}") String instanceAdd) {
        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memLimit);
        env.put("CF_INSTANCE_INDEX", instanceIndx);
        env.put("CF_INSTANCE_ADDR", instanceAdd);
    }

    @GetMapping("/env")
    public Map<String, String> getEnv()
    {
        return env;
    }
}
