package com.trio.belajarws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InstallDaoImpl implements InstallDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Install> findAll() {
		String sql="select dinstall, vidversion, vdescription, vidpatch from ahmdsbsc_mstinstall";
			
		List<Install> list = new ArrayList<Install>();
		
		List<Map<String, Object>> listMap = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> map : listMap) {
			Date dinstall = (Date) map.get("dInstall");
			String vidversion = (String) map.get("vidversion");
			String vdescription = (String) map.get("vdescription");
			String vidpatch = (String) map.get("vidpatch");
			
			Install objectInstall = new Install();
			objectInstall.setDinstall(dinstall);
			objectInstall.setVidversion(vidversion);
			objectInstall.setVdescription(vdescription);
			objectInstall.setVidpatch(vidpatch);
			
			list.add(objectInstall);
			
		}
		
		return list;
	}
	
}
