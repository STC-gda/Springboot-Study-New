package Async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/async")

public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @GetMapping("/movies")
    public String completableFutureTask() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        List<String> words = Arrays.asList("F", "T","S","Z","J","C");

        List<CompletableFuture<List<String>>> completableFutureList =
                words.stream().map(word->asyncService.completableFutureTask(word))
                        .collect(Collectors.toList());

        List<List<String>> results = completableFutureList.stream()
                .map(CompletableFuture::join).collect(Collectors.toList());

        System.out.println("Passed time : " + (System.currentTimeMillis()- start));
        return results.toString();

    }

}
