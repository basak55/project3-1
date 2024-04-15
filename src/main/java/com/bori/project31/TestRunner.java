package com.bori.project31;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestRunner implements ApplicationRunner{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Connection connection = dataSource.getConnection();
		log.info("DBCP: "+dataSource.getConnection()); //사용하는 DBCP타입 확인
		log.info("Url: "+connection.getMetaData().getURL());
		log.info("UserName: "+connection.getMetaData().getUserName());
		
		//Sentence
		jdbcTemplate.execute("INSERT INTO Sentence(sent, writer) VALUES ('노인이 젊은이에게 얘기하듯이 망자도 산자에게 이야기하려고 노력한다면 좋을텐데.', 'Willa Cather')");
		jdbcTemplate.execute("INSERT INTO Sentence(sent, writer) VALUES ('인생은 백치가 지껄이는 이야기와 같다. 시끄럽고 정신없으나 아무 뜻도 없다.', 'William Shakespeare')");
		jdbcTemplate.execute("INSERT INTO Sentence(sent, writer) VALUES ('명성에는 이런 큰 단점도 있는 바, 바로 우리가 그것을 좇을 수록 다른 이들의 비위를 맞추는데 우리 인생을 경주해야한다는 것이다.', 'Baruch Spinoza')");
		jdbcTemplate.execute("INSERT INTO Sentence(sent, writer) VALUES ('인생은 같은 얘기를 또 듣는 것과 같이 나른한 사람의 흐릿한 귀를 거슬리게 한다.', 'William Shakespeare')");
		jdbcTemplate.execute("INSERT INTO Sentence(sent, writer) VALUES ('주간 고속도로 덕택에, 이제 대륙을 횡단하면서 아무 것도 볼 수 없는 일이 가능해졌다.', 'Charles Kuralt')");
		jdbcTemplate.execute("INSERT INTO Sentence(sent, writer) VALUES ('인내할 수 있는 사람은 그가 바라는 것은 무엇이든지 손에 넣을 수 있다.', 'Benjamin Franklin')");
		jdbcTemplate.execute("INSERT INTO Sentence(sent, writer) VALUES ('좋은 인간이 되는 것과 좋은 시민이 되는 것이 항상 같은 것은 아니다.', 'Aristotles')");
		jdbcTemplate.execute("INSERT INTO Sentence(sent, writer) VALUES ('인생은 겸손에 대한 오랜 수업이다.', 'James M. Barrie')");
		jdbcTemplate.execute("INSERT INTO Sentence(sent, writer) VALUES ('인생의 최대 역설은 살아서 빠져나오는 사람이 거의 없다는 점이다.', 'Robert Heinlein')");
		
		//Member
		jdbcTemplate.execute("INSERT INTO Member(mid, mpw, name, gender, exp) VALUES ('admin', 'admin', '김봄이', 'F', 5000)");
		jdbcTemplate.execute("INSERT INTO Member(mid, mpw, name, gender, exp) VALUES ('eyes', 'eyes', '고구마', 'M', 2000)");
		jdbcTemplate.execute("INSERT INTO Member(mid, mpw, name, gender, exp) VALUES ('ears', 'ears', '단추', 'M', 850)");
		jdbcTemplate.execute("INSERT INTO Member(mid, mpw, name, gender, exp) VALUES ('nose', 'nose', '감자', 'M', 50)");
		
		//Record
		jdbcTemplate.execute("INSERT INTO Record(mno, rno, playtime, visit, questcount) VALUES (1, 0, 0, 0, 0)");
		jdbcTemplate.execute("INSERT INTO Record(mno, rno, playtime, visit, questcount) VALUES (2, 0, 0, 0, 0)");
		jdbcTemplate.execute("INSERT INTO Record(mno, rno, playtime, visit, questcount) VALUES (3, 0, 0, 0, 0)");
		jdbcTemplate.execute("INSERT INTO Record(mno, rno, playtime, visit, questcount) VALUES (4, 0, 0, 0, 0)");

		//Level
		jdbcTemplate.execute("INSERT INTO Level(loexp, hiexp, grade) VALUES (0, 99, 'newbie')");
		jdbcTemplate.execute("INSERT INTO Level(loexp, hiexp, grade) VALUES (100, 499, 'silver')");
		jdbcTemplate.execute("INSERT INTO Level(loexp, hiexp, grade) VALUES (500, 1999, 'platinum')");
		jdbcTemplate.execute("INSERT INTO Level(loexp, hiexp, grade) VALUES (2000, 9999, 'challenger')");

		//방명록
		jdbcTemplate.execute("INSERT INTO Guestbook(mno, content, created_date, delete_yn, writer) VALUES (1, '제발 떠라', NOW(), 0, '바삭이')");

		//ranking 현재 회원의 exp보다 큰 값을 가진 다른 회원의 수를 count해서 +1
//		jdbcTemplate.execute("CREATE VIEW member_rank AS SELECT " +
//				"m1.mno, m1.mid, m1.mpw, m1.name, m1.gender, m1.exp, m1.mintro, " +
//				"(SELECT COUNT(*) + 1 FROM member m2 WHERE m2.exp > m1.exp) AS ranking, " +
//				"CASE " +
//				"   WHEN m1.exp >= level.loexp AND m1.exp < level.hiexp THEN level.grade " +
//				"   ELSE NULL " +
//				"END AS grade " +
//				"FROM member m1 " +
//				"INNER JOIN level ON m1.exp >= level.loexp AND m1.exp < level.hiexp");
	}	
}
