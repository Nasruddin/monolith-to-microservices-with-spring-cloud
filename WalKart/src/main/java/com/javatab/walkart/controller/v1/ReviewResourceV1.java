package com.javatab.walkart.controller.v1;

import com.javatab.walkart.common.Constant;
import com.javatab.walkart.controller.BaseController;
import com.javatab.walkart.controller.IReviewResource;
import com.javatab.walkart.dto.ReviewDto;
import com.javatab.walkart.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constant.V1 + "/reviews")
public class ReviewResourceV1 extends BaseController implements IReviewResource {

    private final ReviewService reviewService;

    public List<ReviewDto> findAll() {
        return this.reviewService.findAll();
    }

    public ReviewDto findById(Long id) {
        return this.reviewService.findById(id);
    }

    public ReviewDto create(ReviewDto reviewDto) {
        return this.reviewService.createDto(reviewDto);
    }

    public void delete(Long id) {
        this.reviewService.delete(id);
    }
}
