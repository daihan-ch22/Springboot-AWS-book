// User의 CRUD 담당 인터페이스

package com.danc.book.springboot.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long>
{
    Optional<User> findByEmail(String email); //p179
    // 소셜 로그인으로 반환되는 값 중 email을 통해 이미 생성된 사용자인지, 처음 가입하는 사용자인지 판별 메서드
}
