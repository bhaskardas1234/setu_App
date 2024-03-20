package com.main.setu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.setu.model.admin;
import com.main.setu.repo.adminrepo;

@Service
public class adminService {
	@Autowired
	adminrepo arepo;

	public Boolean getUserAuth(admin admin) {
		//System.out.println(user.getUsername());

		admin validUser = arepo.findByAdminName(admin.getAdminName());
		System.out.println(validUser);

		if (validUser == null) {
			return false;
		} else {
			if (admin.getAdminName().equals((validUser).getAdminName())
					&& admin.getAdminPassword().equals(validUser.getAdminPassword())) {
				return true;
			} else {
				return false;
			}

		}

	}
}
