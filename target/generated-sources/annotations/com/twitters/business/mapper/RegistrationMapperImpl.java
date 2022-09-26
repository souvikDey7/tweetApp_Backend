package com.twitters.business.mapper;

import be.twitter.customerdistribution.types.Credential;
import be.twitter.customerdistribution.types.PostDetails;
import be.twitter.customerdistribution.types.User;
import be.twitter.customerdistribution.types.UserDetails;
import com.twitters.business.dbadapter.dao.CredentialDao;
import com.twitters.business.dbadapter.dao.UserDetailsDao;
import com.twitters.business.model.CredentialDTO;
import com.twitters.business.model.UserDetailsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-13T19:18:02+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class RegistrationMapperImpl implements RegistrationMapper {

    @Override
    public UserDetailsDTO toUserDetailsDTO(UserDetails userDetails) {
        if ( userDetails == null ) {
            return null;
        }

        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();

        userDetailsDTO.setFirstName( userDetails.getFirstName() );
        userDetailsDTO.setLastName( userDetails.getLastName() );
        userDetailsDTO.setEmail( userDetails.getEmail() );
        userDetailsDTO.setContactNumber( userDetails.getContactNumber() );
        userDetailsDTO.setCridential( toCredentialDTO( userDetails.getCridential() ) );

        return userDetailsDTO;
    }

    @Override
    public CredentialDTO toCredentialDTO(Credential credential) {
        if ( credential == null ) {
            return null;
        }

        CredentialDTO credentialDTO = new CredentialDTO();

        credentialDTO.setLoginId( credential.getLoginId() );
        credentialDTO.setPassword( credential.getPassword() );

        return credentialDTO;
    }

    @Override
    public UserDetailsDao toUserDetailsDao(UserDetailsDTO userDetailsDTO) {
        if ( userDetailsDTO == null ) {
            return null;
        }

        UserDetailsDao userDetailsDao = new UserDetailsDao();

        userDetailsDao.setUserId( userDetailsDTOCridentialLoginId( userDetailsDTO ) );
        userDetailsDao.setFirstName( userDetailsDTO.getFirstName() );
        userDetailsDao.setLastName( userDetailsDTO.getLastName() );
        userDetailsDao.setEmail( userDetailsDTO.getEmail() );
        userDetailsDao.setContactNumber( userDetailsDTO.getContactNumber() );

        return userDetailsDao;
    }

    @Override
    public User toUser(UserDetailsDao userDetailsDao) {
        if ( userDetailsDao == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDetailsDao.getUserId() );
        user.setFirstName( userDetailsDao.getFirstName() );
        user.setLastName( userDetailsDao.getLastName() );
        user.setEmail( userDetailsDao.getEmail() );
        user.setContactNumber( userDetailsDao.getContactNumber() );

        return user;
    }

    @Override
    public CredentialDao userDetailsDTOtoCredentialDao(UserDetailsDTO userDetailsDTO) {
        if ( userDetailsDTO == null ) {
            return null;
        }

        CredentialDao credentialDao = new CredentialDao();

        credentialDao.setUserId( userDetailsDTOCridentialLoginId( userDetailsDTO ) );
        credentialDao.setPassword( userDetailsDTOCridentialPassword( userDetailsDTO ) );

        return credentialDao;
    }

    @Override
    public List<PostDetails> toUserPostList(Page<PostDetails> tweets) {
        if ( tweets == null ) {
            return null;
        }

        List<PostDetails> list = new ArrayList<PostDetails>();
        for ( PostDetails postDetails : tweets ) {
            list.add( postDetails );
        }

        return list;
    }

    private String userDetailsDTOCridentialLoginId(UserDetailsDTO userDetailsDTO) {
        if ( userDetailsDTO == null ) {
            return null;
        }
        CredentialDTO cridential = userDetailsDTO.getCridential();
        if ( cridential == null ) {
            return null;
        }
        String loginId = cridential.getLoginId();
        if ( loginId == null ) {
            return null;
        }
        return loginId;
    }

    private String userDetailsDTOCridentialPassword(UserDetailsDTO userDetailsDTO) {
        if ( userDetailsDTO == null ) {
            return null;
        }
        CredentialDTO cridential = userDetailsDTO.getCridential();
        if ( cridential == null ) {
            return null;
        }
        String password = cridential.getPassword();
        if ( password == null ) {
            return null;
        }
        return password;
    }
}
