package egovframework.example.fileDb.service;

import java.util.List;

import egovframework.example.common.Criteria;

public interface FileDbService {
	List<?> selectFileDbList(Criteria criteria);   // 전체 조회
}
