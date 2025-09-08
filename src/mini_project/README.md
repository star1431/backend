## 미니 프로젝트 : 콘솔 영화 관리자 시스템


### 1. 프로젝트 개요

**프로젝트 명**: 콘솔 영화 관리자 시스템

**목표**

* 자바 객체지향 프로그래밍(OOP)의 핵심 요소(클래스, 객체, 캡슐화)를 이해하고 활용합니다.
* `List` ,`Set`, `Map` 과 같은 컬렉션 프레임워크를 사용하여 여러 개의 객체를 관리합니다.
* 콘솔 입출력을 통해 사용자로부터 데이터를 받고 결과를 출력하는 콘솔 구현합니다.

**개발 환경**:

* Java (JDK 21)
* IDE (IntelliJ)


**용도**

* 자바 기초 학습 및 개인 프로젝트 용도 입니다.

---

### 2. 주요 기능

사용자는 콘솔 창에서 다음 기능 메뉴를 선택하여 실행합니다.

1.  **예매 등록**: 영화 선택 → 좌석 입력 → 유효성체크 → 예매등록 처리 구현합니다. 
2.  **예매 취소**: 예매된 영화 선택 → 예매 좌석 입력 → 체크 → 예매취소 처리 구현합니다.
3.  **영화 추가**: 영화 제목,장르,등급,가격 단계별 입력 진행하여 입력값 바탕으로 영화 정보를 추가합니다.
4.  **영화 삭제**: 영화 목록에서 해당 영화를 선택하여 정보를 삭제합니다. 
5.  **영화 목록**: 등록된 모든 영화 목록을 보여주고 영화를 선택하여 해당 좌석 정보를 제공합니다.
6.  **종료**: 프로그램을 종료합니다.


---

### 3. 디렉토리 구조

```bash
mini_project
    │ 
    ├─ control
    │   ├─ MovieController.java     # 영화 데이터 관리
    │   └─ SeatController.java      # 좌석 데이터 관리
    │
    ├─ enums
    │   └─ AgeRating.java           # 영화 관람등급
    │
    ├─ model
    │   └─ Movie.java               # 영화 생성
    │
    ├─ service
    │   └─ MovieService.java        # 영화-좌석 매핑 및 전체 기능 관리
    │
    ├─ MovieMain.java               # 실행
    └─ consoleUI.java               # 콘솔 입력에 따른 업무진행 흐름
```
---

### 4. 클래스 설계


```bash
        MovieMain   # 실행
            ↑ 
        consoleUI   # 메뉴 흐름 진행
            ↑ 
        MovieService  ←  (AgeRating)  # 전체 기능 관리 <- 관람등급 관련 이넘 사용
            ↑ 
     ┌───────────────┐
     │               │
MovieController   SeatController  # 각 데이터 관리
     ↑ 
   Movie # 영화생성

```


<br/>

#### 4.1. `Moive` 클래스

>[!NOTE] 
>**역할**: 영화를 생성하는 클래스입니다.

* **속성 (Fields)**

```java
    private String id;          // 영화 고유 ID
    private String title;       // 영화명
    private String type;        // 등급
    private String genre;       // 장르
    private int price;          // 가격
```

* **기능 (Methods)**
    * 생성자, Getter/Setter 메서드
    * `toString()`, `equals(Obj)` , `hashCode()` 오버라이딩 


<br/><br/>

#### 4.2. `AgeRating` enum

>[!NOTE] 
> **역할**: 영화 관람 등급을 사전에 정의합니다.

* **속성 (Fields)**

```java
    ALL(1, "전체 이용가"),
    R12(2, "12세 이용가"),
    R15(3, "15세 이용가"),
    R19(4, "청소년 관람불가");
    private int code;
    private String label;
```

* **기능 (Methods)**
    * Getter/Setter 메서드
    * `findLabel(code)`: 코드 값 받아 라벨 값 전달
    * `getCodeArray()`: 코드 배열로 가공 후 전달
    * `getLabelArray()`: 라벨 배열로 가공 후 전달

<br/><br/>

#### 4.3. `MovieController` 클래스

>[!NOTE] 
> **역할**: 영화 데이터를 관리하는 클래스입니다.

* **속성 (Fields)**

```java
    // key(영화id) : val(Movie 객체)
    private final Map<String, Movie> movieMap = new LinkedHashMap<>();
    // id 카운트
    private int idCnt = 1;
```

* **기능 (Methods)**
    * `addMovie(...)`: 영화 생성 및 고유 id 값 설정하여 전달
    * `removeMovie(id)`: id 값 받아 해당 영화 제거
    * `getTotal()`: 등록된 영화 수 전달
    * `getId(title)`: 영화 제목에 해당하는 id 전달 
        - 현재 미사용
    * `findMovie(id)`: id 에 해당하는 Moive 인스턴스 전달
    * `getMovieMap()`: moiveMap 접근 허용


<br/><br/>

#### 4.4. `SeatController` 클래스

>[!NOTE] **역할**: 좌석 배열생성 및 관리하는 클래스입니다.

* **속성 (Fields)**

```java
    // key(행값 A..) : val(좌석코드배열 A1..)
    private final Map<String, String[]> seatMap = new LinkedHashMap<>();
    // 예매된 좌석 집합
    private final Set<String> reserveSet = new HashSet<>();
    // 예매 표시 마스킹
    private final String MASKING = "__";
    private int rows; // 행
    private int cols; // 열
```

* **주요기능 (Methods)**
    *  생성자 메서드 : 기본 좌석 배열 및 확장 제공 
        - 확장형은 현재 미사용
    * `initSeatMap()`: 좌석 key-val 설정 `A={A1,A2..}`
    * `reserve(code)`: 코드값 받아 좌석 예매 처리 및 성공여부 boolean 
    * `cancel(code)`: 코드값 받아 좌석 예매 취소 및 성공여부 boolean
    * `getReserveList()`: 예매된 좌석코드값 Set 전달
    * `getTotal()`: 총 좌석 수 전달
    * `getReservedCount()`: 예매된 좌석 수 전달
    * `getLeftCount()`: 남은 좌석 수 전달
    * `getSeatMap()`: seatMap 접근 허용

<br/><br/>

#### 4.5. `MovieService` 클래스

>[!NOTE] 
> **역할**: 각 영화id에 좌석객체 매핑하고 전체적인 기능을 제공합니다.

* **속성 (Fields)**

```java
    private final MovieController movieCtrl = new MovieController();
    // key(영화id) : val(좌석)
    private final Map<String, SeatController> allMap = new LinkedHashMap<>();
    // key(영화id) : val(예매좌석) = 예매 목록 별도 관리용
    private final Map<String, SeatController> reservedMap = new LinkedHashMap<>(); 
```

* **주요기능 (Methods)**
    * `addMovie(...)`: 영화 생성 및 좌석 생성 - id값 받고 allMap에 삽입 
        - enum 값 받는 확장형 생성자 제공
    * `removeMovie(id)`: 해당 영화 관련 데이터 전부 제거
    * `getSeat(id)`:  allMap의 key값 id에 해당되는 좌석 인스턴스 전달
        - 내부사용 편의성 용도
    * `movieTotal()`: 총 영화 수 전달
    * `MovieBoard()`: 영화 전체 목록 출력
    * `reservedMovieBoard()`: 예매된 영화 목록 출력
    * `movieSeatBoard(id)`: 해당 영화 좌석표 출력
    * `movieInfo(id)`:  해당 영화 정보 출력
    * `selectMovie(str,num)` : 목록번호 기반 case별 해당 영화 id 전달
        - 읽기,예매 = 영화목록 기준
        - 취소 = 예매된 영화목록 기준
    * `reserveSeat(id,code)` : 해당 영화 내 좌석번호 값 예매 등록
    * `cancelSeat(id,code)` : 해당 영화 내 좌석번호 값 예매 취소

<br/><br/>
    
#### 4.5. `consoleUI` 클래스

>[!NOTE] 
> **역할**: 콘솔 환경에서 사용자 입력에 따른 메뉴 흐름을 제어하는 클래스입니다.  

* **속성 (Fields)**

```java
    static Scanner sc = new Scanner(System.in);
    static MovieService service = new MovieService();
```

* **주요기능 (Methods)**
    * 생성자 메서드

    * 내외부 용도
        * `initMovie()`: 영화 5개 기본 생성
        * `askBack(str)`:  y/n 질문 케이스별 묶음 및 boolean 전달
        * `printTitle(str)`: 단순 출력 타이틀
        * `printError(str)`: 케이스별 에러 메세지
        * `printSuccess(str)`: 통과 메세지

    * 메뉴 진행
        * `reserveFlow()`: 예매 등록
        * `cancelFlow()`: 예매 취소
        * `addFlow()`: 영화 등록
        * `removeFlow()`: 영화 삭제
        * `listFlow()` : 영화 목록
        * `endFlow()` : 종료 (프린트하나)

<br/><br/>
    
#### 4.5. `MovieMain` 클래스

>[!NOTE] 
> **역할** :  main 실행 클래스 

* `main()` : 선택 값에 따른 메뉴 케이스 진행

---

### 5. 피드백

* `AgeRating` - 연관성 고려
    - 현재 : 임포트 되어 있는 부분이 consoleUI, MoiveSerive 두개에만 되어있음.
    - 개석 : 직접 정보 연관된 Movie에는 해당 이넘을 사용 권장. 연관성에 대해 생각을 해볼 필요 있음

* `SeatController` - 책임분리
    - 현재 : 좌석 배열 생성 + 예약 로직까지 담당하는 이중 책임을 가짐 (단일책임 위반)
    - 개선 : 무비처럼 Seat 클래스 따로 만들어서 책임 분리 필요함

* `MovieService` - 확장성 고려
    - 현재 : 영화ID-좌석 매핑 되어 있으나 확장성에 대해 막혀 있음
    - 개선 : 상영관 등 확장할 만한 구현체 추가 등 확장에 대해 깊게 생각할 필요가 있다.


