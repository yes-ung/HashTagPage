package egovframework.example.gallery.service;

import java.util.List;

import egovframework.example.common.Criteria;

public interface GalleryService {
	List<?> selectGalleryList(Criteria criteria);   // 전체 조회
}
