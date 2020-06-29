![기여자](https://img.shields.io/static/v1?label=프로젝트&message=참여자&color=orange)  <img style="display:inline;" class="avatar" src="https://avatars2.githubusercontent.com/u/59803478?s=40&amp;v=4" width="20" height="20" alt="@32Lab"> <img style="display:inline" class="avatar" src="https://avatars1.githubusercontent.com/u/61299324?s=64&v=4" width="20" height="20" alt="@JOMEYONGYOON"> <img style="display:inline" class="avatar" src="https://avatars3.githubusercontent.com/u/42179250?s=64&v=4" width="20" height="20" alt="@power8128"> <img style="display:inline;" class="avatar" src="https://avatars1.githubusercontent.com/u/61398188?s=64&v=4" width="20" height="20" alt="@thm121"> <br>![version](https://img.shields.io/badge/버젼-v1.0b-yellow)<br>![java se development kit](https://img.shields.io/badge/자바-1.8-red) <br>![license](https://img.shields.io/badge/라이센스-MIT-purple) 

<br/>
<a href="https://blog.naver.com/neat-white-tree?Redirect=Log&logNo=221881317116&from=postView">테스트 영상 - 네이버 블로그</a>
<p>
GOGGLES 프로젝트라고 이름을 지어진 이유는 GOGGLE과 똑같이 검색엔진을 만들면 어떨까 해서 GOGGLE 느낌나게 GOGGLES 지었고, 테마는 미니언즈 캐릭터 들일 고글을 다 쓰고 있어서 미니언즈 배경을 사용하였습니다. 사전을 구현한 이유는 검색엔진을 구현하려면 검색엔진에서 찾을 때 매칭해야 될 키워드가 필요한데 이 키워드를 저장하기 위한 구조를 어떤것일지 생각해보다가 사전 이라는 형태로 구성하면 괜찮을 것 같아서 시작하게되었습니다.
</p>

### 라이브러리
#### Lorem Ipsum
무작위 단어, 문장을 생성하여 글 컨텐츠를 의미없는 텍스트로 생성해주는 라이브러리입니다
```Java
LoremIpsum loremIpSum = new LoremIpsum();
loremIpSum.getEmail();
```
```
lorie.townsend@example.com
stacey.olsen@example.com
andrea.mcfarland@example.com
shaun.trevino@example.com
kurt.ray@example.com
louise.ramirez@example.com
```

### 상수
```
public static final int PADDING = 12;
public static final int FRAME_WIDTH = 1280;
public static final int FRAME_HEIGHT = 720;
public static final String DATABASE = "database";
```

### GUI
##### rgba 색상
```Java
Color color = new Color(1.0F, 1.0F, 1.0F, 0.0F);
setBackground(color);
```

##### 움직이는 컴포넌트
```Java
JLabel label = new JLabel(“움직이는 레이블”);
label.setLocation(x,y);
```

