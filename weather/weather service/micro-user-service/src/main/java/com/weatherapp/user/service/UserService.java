package com.weatherapp.user.service;

import javax.transaction.Transactional;

import com.weatherapp.user.dto.UserDTO;
import com.weatherapp.user.dto.WishListDTO;
import com.weatherapp.user.entity.UserEntity;
import com.weatherapp.user.entity.WishListEntity;
import com.weatherapp.user.repo.UserRepo;
import com.weatherapp.user.repo.WishListRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.weatherapp.user.common.messages.BaseResponse;
import com.weatherapp.user.common.messages.CustomMessage;
import com.weatherapp.user.common.utils.Topic;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private WishListRepo wishlistRepo;



	public BaseResponse createUser(UserDTO userDTO) {
		UserEntity userEntity = copyUserDtoToEntity(userDTO);
		String generatedHash ="{bcrypt}"+ BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(12));
		userEntity.setPassword(generatedHash);
		userEntity.setAccountNonExpired(true);
		userEntity.setAccountNonLocked(true);
		userEntity.setCredentialsNonExpired(true);
		userEntity.setEnabled(true);
		userEntity.setUsername(userDTO.getEmail());
		userRepo.save(userEntity);
		return new BaseResponse(Topic.User.getName() + CustomMessage.SAVE_SUCCESS_MESSAGE, HttpStatus.CREATED.value());
	}

	public BaseResponse updateUser(UserDTO userDTO) {
		userRepo.updateUser(userDTO.getFirstName(),userDTO.getLastName(),userDTO.getPhone(),userDTO.getId());
		return new BaseResponse(Topic.User.getName() + CustomMessage.UPDATE_SUCCESS_MESSAGE, HttpStatus.CREATED.value());
	}

	public BaseResponse updatePassword(UserDTO userDTO) {
		String generatedHash ="{bcrypt}"+ BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(12));
		userRepo.updatePassword(generatedHash,userDTO.getId());
		return new BaseResponse(Topic.Password.getName() + CustomMessage.UPDATE_SUCCESS_MESSAGE, HttpStatus.CREATED.value());
	}

	public BaseResponse createWishList(WishListDTO wishListDTO){

		WishListEntity checkDuplicate=wishlistRepo.findWishListByCityAndId(wishListDTO.getCity().toLowerCase(),wishListDTO.getUserId());
		if(checkDuplicate!=null && checkDuplicate.getCity().length()>0){
			return new BaseResponse(wishListDTO.getCity() + CustomMessage.RECOURD_FOUND_WISHLISH, HttpStatus.CREATED.value());
		}else {
			WishListEntity wishListEntity = copyWishListrDtoToEntity(wishListDTO);

			wishlistRepo.save(wishListEntity);
			return new BaseResponse(Topic.WishList.getName() + CustomMessage.SAVE_SUCCESS_MESSAGE, HttpStatus.CREATED.value());
		}
	}

	public BaseResponse deleteWishList(int id, int userId){
		wishlistRepo.deleteByWisListIdAndUserId(id,userId);
		return new BaseResponse(Topic.WishList.getName() + CustomMessage.DELETE_SUCCESS_MESSAGE, HttpStatus.CREATED.value());
	}

	public List<WishListDTO> getWishList(int  userId){
		Pageable pageable = PageRequest.of(0, 25, Sort.by(Sort.Order.desc("id")));
		List<WishListEntity> wishListEntityList=wishlistRepo.getWishList(userId,pageable).getContent();
		List<WishListDTO> copy = new ArrayList<>();
		WishListDTO wishList=null;
		for(WishListEntity wishListEntity:wishListEntityList){
			wishList=new WishListDTO();
			wishList.setId(wishListEntity.getId());
			wishList.setUserId(wishListEntity.getUserId());
			wishList.setCity(wishListEntity.getCity());
			copy.add(wishList);
		}
		return copy;
	}



	private UserEntity copyUserDtoToEntity(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDTO, userEntity);
		return userEntity;
	}

	private WishListEntity copyWishListrDtoToEntity(WishListDTO wishListDTO) {
		WishListEntity wishListEntity = new WishListEntity();
		BeanUtils.copyProperties(wishListDTO, wishListEntity);
		return wishListEntity;
	}


}
