package com.devpro.shop16.services;

import org.springframework.stereotype.Service;

import com.devpro.shop16.entities.ProductImage;

@Service

public class ProductImageService extends BaseService<ProductImage>{

	@Override
	protected Class<ProductImage> clazz() {
		// TODO Auto-generated method stub
		return ProductImage.class;
	}

}
