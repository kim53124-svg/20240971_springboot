## 2주차: 개발환경 설정 및 테스트

백엔드 프로그래밍의 개요를 익히고, VS Code 기반의 Spring Boot 개발 환경을 구축하여 첫 웹 서버를 구동합니다.

**• 이론 학습:**

◦ 백엔드 프로그래밍과 프레임워크의 필요성  
◦ JVM과 자바의 특징  
◦ Spring Boot 프로젝트 구조(Maven, pom.xml)와 MVC 패턴(Model, View, Controller)의 이해  
◦ Thymeleaf 템플릿 엔진의 개념과 기본 문법

**• 실습 소스코드:** 

◦ DemoApplication.java: 스프링 부트 실행을 위한 메인 애플리케이션 클래스  
◦ DemoController.java: URL 맵핑을 위한 기본 컨트롤러 생성 (@GetMapping)  
◦ index.html: resources/templates 폴더에 메인 페이지 생성 및 Thymeleaf 설정  
    
---

## 3주차: 포트폴리오 작성하기 (프론트엔드)

**• 이론 학습:**

 ◦ 자바와 C#의 비교 및 Spring Boot 기술 스택 이해  
 ◦ 정적 자원(Static)과 동적 템플릿(Templates)의 폴더 구조 분리 및 관리  
 ◦ 부트스트랩의 그리드 시스템, 컴포넌트, 외부 라이브러리(Google Fonts 등) 활용법  

**• 실습 소스코드:**

◦ index.html: 부트스트랩 템플릿을 templates 폴더로 이동 및 개인 정보(프로필, 기술 스택 등) 수정  
◦ DemoController.java: 상세 페이지(/about_detailed) 연결을 위한 맵핑 추가  
◦ about_detailed.html: 개인 소개 상세 페이지 생성 및 하이퍼링크 연결  

---

## 4주차: 데이터베이스 연동 및 테스트

**• 이론 학습:**

◦ RDBMS(MySQL)와 NoSQL의 차이, 데이터베이스 선택 기준  
◦ ORM(Object-Relational Mapping)과 JPA의 역할, 영속성 컨텍스트 개념  
◦ 계층형 아키텍처(Domain, Repository, Service, Controller)의 필요성과 구조  

**• 실습 소스코드:**

◦ application.properties: MySQL 접속 정보 및 JPA 설정 추가  
◦ TestDB.java: @Entity를 사용한 데이터베이스 테이블 매핑 클래스 생성  
◦ TestRepository.java: JpaRepository를 상속받아 DB 제어 기능 구현  
◦ TestService.java: 비즈니스 로직 처리 및 리포지토리 연결  
◦ DemoController.java: DB 데이터를 조회하여 뷰로 전달하는 기능 추가  

---
    
## 5주차: 블로그 게시판 - 1 (조회/글쓰기)

**• 이론 학습:**

◦ REST API의 개념(자원, 행위, 표현)과 HTTP 메서드(GET, POST 등)에 따른 CRUD 동작  
◦ 빌더(Builder) 패턴을 이용한 객체 생성과 DTO(Data Transfer Object)의 필요성  

**• 실습 소스코드:**

◦ Article.java: 게시글 저장을 위한 엔티티 클래스 정의  
◦ BlogController.java: 게시글 목록(/article_list) 조회 기능 구현  
◦ BlogRestController.java: 게시글 저장을 위한 POST API 구현 (/api/articles)  
◦ AddArticleRequest.java: 게시글 저장 요청을 처리하는 DTO 작성  
◦ article_list.html: 타임리프 반복문(th:each)을 이용한 게시글 목록 출력  

---
    
## 6주차: 블로그 게시판 - 2 (수정/삭제)

**• 이론 학습:**

◦ ORM 매핑과 영속성 관리(더티 체킹), 생명주기 관리  
◦ HTML Form의 한계(GET/POST만 지원)와 HiddenHttpMethodFilter를 이용한 PUT/DELETE 구현  

**• 실습 소스코드:**

◦ BlogController.java: 수정(/api/article_edit) 및 삭제(/api/article_delete) 맵핑 추가  
◦ Article.java: 데이터 수정을 위한 update 메서드 추가  
◦ article_edit.html: 게시글 수정을 위한 폼 생성 (PUT 방식)  
◦ article_error.html: 잘못된 접근 시 보여줄 에러 페이지 구현  

---
    
## 7주차: 블로그 게시판 - 추가 수정

**• 이론 학습:**

◦ JPA Repository의 상속 구조와 CRUD 외의 세부 메서드 활용  
◦ 복잡한 쿼리 처리를 위한 메서드 확장 필요성  

**• 실습 소스코드:**

◦ Board.java: 작성자, 작성일, 조회수 등이 포함된 새 엔티티 생성  
◦ BoardRepository.java: 새 엔티티를 위한 리포지토리 인터페이스 생성  
◦ BlogController.java: /board_list, /board_view 등 새 게시판용 컨트롤러 맵핑  
◦ board_list.html, board_view.html: 확장된 기능을 포함한 뷰 페이지 작성  

---
    
## 9주차: 게시판 - 검색과 페이징

**• 이론 학습:**

◦ 웹 서버 성능 최적화와 데이터 규모별 처리 전략  
◦ Spring Data JPA의 Pageable 인터페이스와 쿼리 메서드(findByTitleContaining) 활용  

**• 실습 소스코드:**

◦ BlogController.java: PageRequest를 이용한 페이징 및 키워드 검색 로직 추가  
◦ BlogService.java: 페이징과 검색을 지원하는 searchByKeyword 메서드 구현  
◦ board_list.html: 검색창 폼 추가 및 하단 페이징 내비게이션 UI 구현  
◦ board_write.html: 글쓰기 폼 구현 및 컨트롤러 연결  

---
    
## 10주차: 로그인과 로그아웃 - 1 (보안 설정)

**• 이론 학습:**

◦ Spring Security의 기본 동작(인증/인가), Security Filter Chain, BCrypt 암호화 알고리즘  
◦ 입력값 검증(Validation)의 필요성  

**• 실습 소스코드:**

◦ SecurityConfig.java: 스프링 시큐리티 설정 및 BCryptPasswordEncoder 빈 등록  
◦ Member.java: 회원 정보를 담을 엔티티 생성  
◦ MemberController.java: 회원가입(/join_new) 및 로그인(/api/login_check) 처리  
◦ MemberService.java: 중복 회원 검증 및 비밀번호 암호화 저장 로직  
◦ join_new.html, login.html: 회원가입 및 로그인 페이지 구현  

---
    
## 11주차: 로그인과 로그아웃 - 2 (세션 관리)

**• 이론 학습:**

◦ Spring Session과 HttpSession, 세션 쿠키(JSESSIONID)의 동작 원리  
◦ 보안 설정(CSRF, XSS, 동시 세션 제어)  

**• 실습 소스코드:**

◦ MemberController.java: 로그인 시 세션 생성, 로그아웃 시 세션 무효화(invalidate) 및 쿠키 삭제 로직  
◦ BlogController.java: 세션 존재 여부를 확인하여 게시판 접근 제어  
◦ SecurityConfig.java: 세션 만료, 동시 세션 제한 등 보안 설정 추가  
◦ board_list.html: 로그인한 사용자 정보 출력 및 로그아웃 버튼 추가  

---
    
## 12주차: 포트폴리오 완성

**• 이론 학습:**

◦ Multipart 파일 처리 및 I/O 스트림을 이용한 서버 저장  
◦ GitHub Pages를 이용한 정적 웹 사이트 호스팅 개념  

**• 실습 소스코드:**

◦ index.html: 메일 보내기 폼(파일 업로드용) 및 구글 맵 연동 수정  
◦ FileController.java: 파일 업로드 처리를 위한 컨트롤러 구현 및 경로 설정  
◦ SecurityConfig.java: 파일 업로드를 위해 CSRF 설정 비활성화  
◦ upload_end.html: 업로드 완료 페이지 작성  
