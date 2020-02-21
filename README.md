정의(도)&amp;이(평)복의 연구소

AMI System 개발 가이드
===================
개발하기 앞서서 개발자로써 CNU Global 코드의 정규화 및 코드의 일관성을 유지시키기 위하여 일부 규칙을 지키길 바라며 작성합니다.
순서와 연관없이 생각나는데로 작성하기에 앞뒤가 안 맞을수 있으나 꼭 필요한 내용들이니 준수하여주시기 부탁드립니다.

> **필자가 전하는말:**

> - 사람이 개발하는것이기에 로봇도 아니고 항상 100% 완벽한 통일성을 보장할 수는 없습니다. 그래도 코드를 최대한 맞춰서 작업을 해야한다고 판단되는 부분입니다.
> - 필자가 100% 정답이라고 볼 수는 없습니다. 단지, 아래의 규칙 기준하에 개발되었다는 기준으로 문서를 참고하면 참고하시기 바랍니다.
> - WEB에서 지켜야할 부분이 많습니다. 이는 개발제약을 두기 위함이 아닌 JAVA처럼 문법 체크가 되지 않다보니 중구난방으로 작성되는 코드를 최소한으로 정규화 시키기위함으로 바라봐주셨으면 좋겠습니다.
> - 필자 역시 최대한 아래와 같은 규칙들을 지키려고 노력할 것이고 놓칠수도 있습니다. **비판은 할수 있되 비난은 자제** 부탁드리며 글을 마칩니다.   pblee@cnuglobal.com
> - **본글을 메모장 및 기타 프로그램에 열으셨다면 https://stackedit.io/editor 에다가 복사 붙여넣기 하여 읽으시길 바랍니다.**
---

## Code Rule (Common)
- 과도한 칸띄움은 지양한다.
  ```java
  for ( int i = 0 ; i < 2 ; i++ ) {}	// (x)
  for (int i=0 ; i<2; i++) {}	// (o)
  ```
- 줄띄움은 다음과 같은 사항이 아니면 사용하지 않되 가독성이 심하게 떨어지는 경우엔 구분해주어 사용한다.
  ```
  a. 함수와 함수간인 경우
  b. 흐름제어문 (if, for, while, try 등)의 사용
  c. return 사용
  ```
- 한줄 코드는 가독성을 낮추므로 자제해야한다. (단 라이브러리 성향을 지닌 고정적인 코드들은 상관없다)
  ```javascript
  if (n > 0) break; (x)
  if (n > 0) {      (o)
      break;	  
  }
  ```
- 3항 연산자는 사용하지 않는다.
  ```
  return n.length >= width ? n : new Array(width - n.length + 1).join('0') + n; (x)
  ```

---

## Code Rule (JAVA)
- 클래스명을 제외한 모든 표기는 Camel표기법으로 통일한다. (접두어, 접미어에 약어가 들어가는 경우엔 개인판단에 맡긴다.)
- MVC패턴으로 개발을 하되 service 단에서 단위기능 코드는 service.bizproc에 넣고 사용한다. (결합도를 낮추면서 재사용성을 높이는 방식 --> 본소스에서는 CRUD중 CUD를 거의 사용않기 때문에 들어가는 경우가 적은편이다.)
- Controller : 로직에 관한 모든 부분은 서비스에게 맡기되 컨트롤러가 해야할 역할인 Parameter getting하는데 있어서 부득이하게 로직이 들어가야할 경우 AbsController를 이용한다.
- 변수 선언시 접두어를 사용하지 않는다.
  ```java
  int nCount; (x)
  int count; (o)
  ```
- 변수명은 약어 사용을 지양한다.
  ```java
  int cnt; (x)
  int count; (o)
  ```

---


## Code Rule (WEB)
- WEB상에서는 기본 문법은 javascript + jQuery를 사용한다.
- 모든 표기는 Camel표기법으로 통일한다.
- javascript 작성시에는 문자표기 방식은 [" "], [' '], [\\" \\"] 순으로 사용한다. (통일시키는것을 목적)
  ```javascript
  var tmp = [];
  tmp.push("$('#div').attr('onclick', 'javascript:test(\"abc\")')");
  ```
- 웹상의 모든 리소스 코드는 다국어 지원하기 위하여 다음과 같이 적용한다.
  - html를 사용하는 경우 `jstl`의 `fmt`태그를 사용
    ```html
    <span><fmt:message key="ami.product.name"/></span>
    ```
  - javascript를 사용하는 경우 .../js/res/resController.js를 참조하여 사용한다.
    ```javascript
    var home = AMI_RES.get("ami_menu_home");
    // 치환 문자는 다음과 같이 처리한다. {n}
    var msg = AMI_RES.get("ami_msg_must_select", "지역코드");	// {1}는(은) 반드시 선택해주세요.
    var msg = AMI_RES.get("ami_msg_must_select", "지역코드", "아파트명", ...);	// {1}는(은) 반드시 선택해주세요. {2}도 채워주세요! n개 만큼 치환가능합니다.
    ```
- javascript 코드내에서 html 코드를 직접 사용하는 방식은 지양한다.
  - javascript 코드내에서 html 코드를 조합하는 경우엔 PAGE_CONTROLLER을 사용하여 조합한다.
- html에 조합할 때에는 다음과 같이 사용한다. (Array를 사용하는 이유는 코드의 통일성과 한줄코드로 완성되는 경우는 거의 없다. 이에 따른 분류법을 통일시키기 위함이다.)
  ```javascript
  var tmp = [];
  tmp.push("<ul>");
  tmp.push("	<li>오렌지</li>");	
  tmp.push("	<li>사과</li>");		// 코드 가독성을 높이기 위해 탭을 두는 여백의 미도 괜찮다.
  tmp.push("</ul>");
  $("#div").html(tmp.join("\n"));
  ```
- html엘리먼트들 중에서 id 어트리뷰트값은 유니크해야한다! 라고 되있지만 유니크를 준수하되 selector 접근성은 다음과 같이 특정 view를 분기점을 두고 접근한다.
  ```javascript
  var view = $("#contentsBody");
  view.find("#searchArea").find("#dcuId").html("dcuId");
  view.find("#searchArea").addClass("active");
  ```
- api콜과 그에 따른 콜백은 다음과 같은 순서를 지켜주길 바라며 function의 접두어로는 동사를 사용하여주기 바란다.
  ```javascript
  function showDcuList() {
	// jsp페이지 호출 구문
	var viewName = "equipmentDcu"
	AMI_PROXY.invokeOpenAPI(viewName, "html", param, function(result, _params) {
		$("#mainBody").html(result);
		getDcuList();
	}
  }
  function getDcuList() {
	AMI_PROXY.invokeOpenAPI("getDcuList", "json", param, renderDcuList);
  }
  function renderDcuList(result, _head, params) {
	if (result.dataList != null) {
		var view = $("#mainBody");
	}
  }
  ```
  |접두어              |설명                          |
  |----------------|-------------------------------|
  |show|html elements콜을 사용할때 사용|
  |get|json API콜을 사용할때 사용|
  |render|api 호출 후 callback 함수|

---


## 주요 클래스 목록


> **Tip:** 개인적으로 보고 가야한다 싶은 목록들만 정리하였기에 원하는 클래스에 대한 설명이 없을 수 있습니다.

  ```
  <script type="text/javascript" src="/ami/js/amiProxy.js"></script>
  ```


---


## 표테스트

뭐이리 어렵댜 - 근데 쓸대가 없을듯....

|                |ASCII                          |HTML                         |
|----------------|-------------------------------|-----------------------------|
|Single backticks|`'Isn't this fun?'`            |'Isn't this fun?'            |
|Quotes          |`"Isn't this fun?"`            |"Isn't this fun?"            |
|Dashes          |`-- is en-dash, --- is em-dash`|-- is en-dash, --- is em-dash|


---


## Open Source Library
> 그래프 : 여기를 눌러주세요. 현재미정 [여기](http://www.naver.com).


---


## 로그인 UML diagrams
로그인을 하기위해 다음과 같은 구조로 수행을 하고 있습니다.

이미지 첨부 테스트
![플로우챠트](https://user-images.githubusercontent.com/20449373/62184325-85a38d80-b398-11e9-843f-a4faa08fdb89.PNG)

