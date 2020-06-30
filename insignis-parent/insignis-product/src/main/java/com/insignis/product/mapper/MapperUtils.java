package com.insignis.product.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

import com.insignis.product.domain.Category;
import com.insignis.product.domain.Product;
import com.insignis.product.domain.Review;
import com.insignis.shared.dto.CategoryDTO;
import com.insignis.shared.dto.ProductDTO;
import com.insignis.shared.dto.ReviewDTO;
import com.insignis.shared.dto.SupplierDTO;

public class MapperUtils {

	public static Function<Product, ProductDTO> ProductDTOMapper() {
		return product -> {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setUnitPrice(product.getUnitPrice());
			productDTO.setProductId(product.getProductId());
			productDTO.setCategories(product.getCategories().stream().map(CategoryDTOMapper()).collect(Collectors.toList()));
			SupplierDTO supplier = new SupplierDTO();
			supplier.setId(product.getSupplierId());
			productDTO.setSupplier(supplier);

			productDTO.setOffer(product.getOffer());
			productDTO.setSize(product.getSize());
			productDTO.setColor(product.getColor());
			productDTO.setBuyingPrice(product.getBuyingPrice());
			productDTO.setDiscount(product.getDiscount());

			productDTO.setStock(product.getStock());
			productDTO.setBought(product.getBought());
			productDTO.setDescription(product.getDescription());
			productDTO.setImage(product.getImage());
			productDTO.setCurrency(product.getCurrency());
			productDTO.setSpecs(product.getSpecs());
			productDTO.setBuyerGuarantee(product.getBuyerGuarantee());
			productDTO.setReviews(product.getReviews().stream().map(reviewDTOMapper()).collect(Collectors.toList()));
			productDTO.setStoreReviews(product.getStoreReviews().stream().map(reviewDTOMapper()).collect(Collectors.toList()));
			return productDTO;
		};
	}

	public static Function<ProductDTO, Product> productMapper() {
		return productDto -> {
			Product product = new Product();
			product.setId(productDto.getId());
			product.setName(productDto.getName());
			product.setUnitPrice(productDto.getUnitPrice());
			product.setSupplierId(productDto.getSupplier().getId());
			product.setProductId(productDto.getProductId());
			product.setCategories(productDto.getCategories().stream().map(categoryMapper()).collect(Collectors.toList()));

			product.setOffer(productDto.getOffer());
			product.setSize(productDto.getSize());
			product.setColor(productDto.getColor());
			product.setBuyingPrice(productDto.getBuyingPrice());
			product.setDiscount(productDto.getDiscount());

			product.setStock(productDto.getStock());
			product.setBought(productDto.getBought());
			product.setDescription(productDto.getDescription());
			product.setImage(productDto.getImage());
			product.setCurrency(productDto.getCurrency());
			product.setSpecs(productDto.getSpecs());
			product.setBuyerGuarantee(productDto.getBuyerGuarantee());
			product.setReviews(productDto.getReviews().stream().map(reviewMapper()).collect(Collectors.toList()));
			product.setStoreReviews(productDto.getStoreReviews().stream().map(reviewMapper()).collect(Collectors.toList()));

			return product;
		};
	}

	public static Function<CategoryDTO, Category> categoryMapper() {
		return categoryDto -> {
			Category category = new Category();
			category.setCategory(categoryDto.getCategory());
			category.setId(categoryDto.getId());
			return category;
		};
	}

	public static Function<Category, CategoryDTO> CategoryDTOMapper() {
		return cat -> {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setCategory(cat.getCategory());
			categoryDTO.setId(cat.getId());
			return categoryDTO;
		};
	}

	public static Function<ReviewDTO, Review> reviewMapper() {
		return reviewDTO -> {
			Review review = new Review();
			review.setComment(reviewDTO.getComment());
			review.setImage(reviewDTO.getImage());
			review.setImages(reviewDTO.getImages());
			review.setName(reviewDTO.getName());
			review.setRating(reviewDTO.getRating());
			return review;
		};
	}

	public static Function<Review, ReviewDTO> reviewDTOMapper() {
		return review -> {
			ReviewDTO reviewDTO = new ReviewDTO();
			reviewDTO.setComment(review.getComment());
			reviewDTO.setImage(review.getImage());
			reviewDTO.setImages(review.getImages());
			reviewDTO.setName(review.getName());
			reviewDTO.setRating(review.getRating());
			return reviewDTO;
		};
	}

}
