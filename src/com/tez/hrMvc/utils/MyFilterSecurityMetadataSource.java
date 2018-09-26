package com.tez.hrMvc.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.tez.hrMvc.model.ProfilMenuTree;
import com.tez.hrMvc.service.ProfilMenuTreeService;

public class MyFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	@Autowired
	ProfilMenuTreeService service;

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		FilterInvocation fi = (FilterInvocation) object;
		String url = fi.getRequestUrl();
		List<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();

		attributes = getAttributesByURL(url);

		return attributes;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

	public List<ConfigAttribute> getAttributesByURL(String inputUrl) {
		List<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();

		List<ProfilMenuTree> tree = service.findbyUrl(inputUrl);

		for (ProfilMenuTree p : tree) {


			String role=p.getProfil().getLibProfil();
			ConfigAttribute attribute = new SecurityConfig(role);
			attributes.add(attribute);
		}
		return attributes;
	}

}
