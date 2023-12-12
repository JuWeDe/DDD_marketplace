package com.example.ddd_lab2.Factories;

import com.example.ddd_lab2.Aggregates.Promotion;
import com.example.ddd_lab2.Repositories.PromotionRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PromotionFactory {

    private final PromotionRepo promotionRepo;

    public PromotionFactory(PromotionRepo promotionRepo) {
        this.promotionRepo = promotionRepo;
    }


    public Promotion createPromotion(String promotionName, String endDate, String startDate, Long productId) {
        Promotion promotion = new Promotion();
        promotion.setPromotionName(promotionName);
        promotion.setStartDate(LocalDate.parse(startDate));
        promotion.setEndDate(LocalDate.parse(endDate));
        promotion.setProduct_id(productId);
        return promotionRepo.save(promotion);
    }
}
