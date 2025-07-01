package egovframework.example.fileDb.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.common.Criteria;
/**
 * 
 * @author user
 * 마이바티스 : 1) 인터페이스(함수명) 2) xml(sql)
 *
 */
@Mapper
public interface FileDbMapper {
	public List<?> selectFileDbList(Criteria criteria);   // 전체 조회

}
