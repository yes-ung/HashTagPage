package egovframework.example.fileDb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.common.Criteria;
import egovframework.example.fileDb.service.FileDbService;

@Service
public class FileDbServiceImpl implements FileDbService {
	
	@Autowired
	private FileDbMapper fileDbMapper ;

//	전체 조회
	@Override
	public List<?> selectFileDbList(Criteria criteria) {
		// TODO Auto-generated method stub
		return fileDbMapper.selectFileDbList(criteria);
	}
	

}
