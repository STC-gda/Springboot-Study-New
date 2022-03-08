package Async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class AsyncService {
    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    private List<String> movies=
        new ArrayList<>(
                Arrays.asList(
                        "Forrest Gump" +
                        "Titanic" +
                        "Spirited Away" +
                        "Long Time No See" +
                        "Zootopia" +
                        "The ShawnShank Redemption" +
                        "Joker" +
                        "Crawler" +
                        "FareWell" +
                        "The Longest Day"));

    @Async
    public CompletableFuture<List<String>> completableFutureTask(String start){
            logger.warn(Thread.currentThread().getName()+"Oho-ho, it starts now!");

            List<String> results =
                    movies.stream().filter(movie -> movie.startsWith(start))
                            .collect(Collectors.toList());
            try{
                Thread.sleep(1000L);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            return CompletableFuture.completedFuture(results);
        }




}
