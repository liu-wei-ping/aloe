package com.aloe.service.right.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloe.mapper.RightInfoEntiryMapper;
import com.aloe.service.BaseService;
import com.aloe.service.right.IRightService;

/**
 * @author liu_wp
 * @date 2017年10月9日
 * @see
 */
@Service
public class RightServiceImpl extends BaseService implements IRightService {
	@Autowired
	private RightInfoEntiryMapper mapper;

	@Override
	public List<String> getRightCodesByUserNo(String userNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
