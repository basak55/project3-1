package com.bori.project31.repository;

import com.bori.project31.model.LikeRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikedMapper {

    public void like(LikeRequest params);
}
