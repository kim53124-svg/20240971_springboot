## 2주차: 개발환경 설정 및 테스트
**핵심 내용**
- 백엔드 프로그래밍과 스프링 부트 프레임워크의 이해
- 개발 환경 구축 (VS Code, JDK 17/21, Extension Pack)
- 스프링 부트 프로젝트 구조 및 실행 방법
- Thymeleaf 템플릿 엔진 기초 및 Git 연동

**주요 실습 코드**
- **DemoApplication.java**: `@SpringBootApplication` 어노테이션을 통한 자동 설정 확인.
- **DemoController.java**: `@Controller`, `@GetMapping`을 이용한 기본 URL 맵핑.
- **index.html**: Thymeleaf (`xmlns:th`) 네임스페이스 선언 및 데이터 바인딩 테스트.

---

## 3주차: 포트폴리오 작성하기 (프론트엔드)
**핵심 내용**
- 자바와 C# 기술 스택 비교
- 부트스트랩 5 기반 템플릿(ProMan) 적용 및 정적 리소스 관리 (`static` 폴더)
- 포트폴리오 메인 화면 및 상세 페이지(`about_detailed`) 구성

**주요 실습 코드**
- **application.properties**: 정적 리소스 경로 설정 확인.
- **DemoController.java**: `/about_detailed` 경로 맵핑 추가.
- **HTML/CSS**: 부트스트랩 클래스를 활용한 네비게이션 바, 프로필 섹션, 스킬 섹션 수정.

---

## 4주차: 데이터베이스 연동 및 테스트
**핵심 내용**
- MySQL 설치 및 데이터베이스 생성
- Spring Data JPA 개념 및 ORM 매핑 이해
- MVC 패턴 구조화 (Domain, Repository, Service, Controller)

**주요 설정 및 코드**
- **pom.xml**: `mysql-connector-j`, `spring-boot-starter-data-jpa` 의존성 추가.
- **application.properties**:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/spring?serverTimezone=Asia/Seoul
  spring.datasource.username=root
  spring.datasource.password=패스워드
  spring.jpa.hibernate.ddl-auto=update
• TestDB.java: @Entity, @Id, @GeneratedValue를 이용한 엔티티 설계.
• TestRepository.java: JpaRepository 인터페이스 상속.

--------------------------------------------------------------------------------
5주차: 블로그 게시판 1 (REST API 및 글쓰기)
핵심 내용
• REST API 개념 및 HTTP 메서드 이해
• 게시글(Article) 엔티티 설계 및 Builder 패턴 적용
• 게시글 목록 조회 및 작성 기능 구현
주요 실습 코드
• Article.java: @Builder, @NoArgsConstructor 등을 활용한 엔티티 구성.
• BlogRestController.java: @RestController를 사용하여 JSON 응답 처리 (/api/articles).
• AddArticleRequest.java: 게시글 저장을 위한 DTO(Data Transfer Object) 생성.
• BlogService.java: save() 및 findAll() 메서드 구현.

--------------------------------------------------------------------------------
6주차: 블로그 게시판 2 (수정 및 삭제)
핵심 내용
• 게시글 수정(PUT) 및 삭제(DELETE) 로직 구현
• 영속성 컨텍스트와 더티 체킹(Dirty Checking) 이해
• 예외 처리 및 에러 페이지 구현
주요 설정 및 코드
• application.properties:
• Article.java: 데이터 수정을 위한 update() 비즈니스 메서드 추가.
• BlogController.java: @PutMapping, @DeleteMapping 매핑.
• article_edit.html: <input type="hidden" name="_method" value="put">을 이용한 수정 폼 작성.

--------------------------------------------------------------------------------
7주차: 블로그 게시판 추가 수정 (리팩토링)
핵심 내용
• 기존 Article을 확장하여 Board 엔티티 생성 (작성자, 조회수 등 필드 추가)
• 리포지토리 및 서비스 계층 리팩토링
• 게시판 목록 및 상세 보기 UI 개선
주요 실습 코드
• Board.java: user, newdate, count, likec 필드 추가.
• BoardRepository.java: JpaRepository<Board, Long> 상속.
• BlogService.java: Board 엔티티 기반으로 로직 변경.
• board_view.html: 게시글 상세 보기 및 수정/삭제 버튼 연동.

--------------------------------------------------------------------------------
9주차: 게시판 검색과 페이징
핵심 내용
• 대규모 데이터 처리를 위한 페이징 기법 (Page, Pageable)
• JPA 쿼리 메서드를 이용한 검색 기능 (findByTitleContaining...)
• 페이징 네비게이션 UI 구현
주요 실습 코드
• BoardRepository.java:
• BlogController.java: @RequestParam으로 page, keyword를 받아 서비스로 전달.
• board_list.html: 검색 폼(GET 방식) 및 페이지 번호 반복 출력 로직 (th:each="i : ${#numbers.sequence(...)}").

--------------------------------------------------------------------------------
10주차: 로그인과 로그아웃 1
핵심 내용
• Spring Security 기본 설정 및 SecurityFilterChain
• PasswordEncoder(BCrypt)를 이용한 비밀번호 암호화
• 회원가입(Member) 로직 및 Validation 처리
주요 실습 코드
• pom.xml: spring-boot-starter-security, spring-boot-starter-validation 추가.
• SecurityConfig.java:
• MemberService.java: 회원가입 시 비밀번호 암호화 후 저장.

--------------------------------------------------------------------------------
11주차: 로그인과 로그아웃 2
핵심 내용
• HttpSession을 이용한 세션 관리 (로그인 유지)
• 로그인/로그아웃 컨트롤러 구현 (세션 생성 및 무효화)
• 보안 헤더 설정 (XSS Protection)
주요 실습 코드
• MemberController.java:
    ◦ 로그인 성공: session.setAttribute("userId", ...)
    ◦ 로그아웃: session.invalidate() 및 쿠키 삭제.
• SecurityConfig.java: 세션 만료 정책 및 CSRF 설정.
• board_list.html: 로그인 상태에 따라 사용자 이메일 표시 및 로그아웃 버튼 활성화.

--------------------------------------------------------------------------------
12주차: 포트폴리오 완성
핵심 내용
• 파일 업로드 기능 구현 (FileController)
• Google Maps iframe 임베딩
• GitHub Pages를 이용한 정적 배포
주요 실습 코드
• FileController.java: Multipart 처리가 아닌 로컬 경로에 텍스트 파일 생성 예제 구현.
• index.html: 이메일 전송 폼 (action="/upload-email") 및 지도 API 연동.
• application.properties: 파일 업로드 경로 설정 (spring.servlet.multipart.location).
