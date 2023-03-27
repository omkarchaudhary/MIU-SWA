package com.miu.librarysystem.clients;

import com.miu.librarysystem.dtos.ReviewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId = "reviewClient", name = "APIGATEWAY-SERVICE")
public interface ReviewsClient {
    @PostMapping("/review")
    public void saveReview(@RequestBody ReviewDTO reviewDTO);
}
