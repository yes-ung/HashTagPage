package egovframework.example.gallery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.common.Criteria;
import egovframework.example.gallery.service.GalleryService;
@Service
public class GalleryServiceImpl implements GalleryService {
	
	  @Autowired
      private GalleryMapper galleryMapper;

	@Override
	public List<?> selectGalleryList(Criteria criteria) {
		// TODO Auto-generated method stub
		return galleryMapper.selectGalleryList(criteria);
	}
      
      
}
