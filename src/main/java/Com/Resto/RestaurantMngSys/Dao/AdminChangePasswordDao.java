package Com.Resto.RestaurantMngSys.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.Resto.RestaurantMngSys.Entity.Admin;



public interface AdminChangePasswordDao extends JpaRepository<Admin, String> {

	Admin findByAdusrname(String adusrname);

}
