package egovframework.example.gallery.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.common.Criteria;

@Mapper
public interface GalleryMapper {
	public List<?> selectGalleryList(Criteria criteria);   // 전체 조회
}
