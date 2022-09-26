package com.twitters.business.mapper;

import be.twitter.customerdistribution.types.PostDetails;
import com.twitters.business.dbadapter.dao.PostDao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-13T19:18:03+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class SearchMapperImpl implements SearchMapper {

    @Override
    public List<PostDetails> toPostDetails(List<PostDao> post) {
        if ( post == null ) {
            return null;
        }

        List<PostDetails> list = new ArrayList<PostDetails>( post.size() );
        for ( PostDao postDao : post ) {
            list.add( postDaoToPostDetails( postDao ) );
        }

        return list;
    }

    protected PostDetails postDaoToPostDetails(PostDao postDao) {
        if ( postDao == null ) {
            return null;
        }

        PostDetails postDetails = new PostDetails();

        postDetails.setUserId( postDao.getUserId() );
        postDetails.setPostData( postDao.getPostData() );
        postDetails.setLike( postDao.getLike() );
        if ( postDao.getTime() != null ) {
            postDetails.setTime( new SimpleDateFormat().format( postDao.getTime() ) );
        }

        return postDetails;
    }
}
