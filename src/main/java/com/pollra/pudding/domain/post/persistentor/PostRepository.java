package com.pollra.pudding.domain.post.persistentor;

import com.pollra.pudding.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @since       2021.07.06
 * @author      pollra
 * @description post repository
 **********************************************************************************************************************/
public interface PostRepository extends JpaRepository<Post, Long> {
}
