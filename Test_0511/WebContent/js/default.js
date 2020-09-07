/**
 * 
 */
function checkForm() {
	setTimeout(function() {
	}, 3000);
	// 주어진 시간(3초 이후에)

	if (document.regMem.custname.value == '') {
		// 이름을 입력하지 않았다면,
		window.alert("회원성명이 입력되지 않았습니다.");
		// 알림창을 띄우고,
		document.regMem.custname.value = "";
		// 이름창은 공백으로 초기화.
		document.regMem.custname.focus();
		// 이름창에 커서를 이동.
		return false;
		// true 이면 폼 전송
		// false 이면 전송 중지, 폼에 머무름.
	}

	if (document.regMem.phone.value == '') {
		window.alert("회원전화가 입력되지 않았습니다.");
		document.regMem.phone.value = "";
		document.regMem.phone.value = "";
		return false;
	}
	if (document.regMem.address.value == '') {
		window.alert("회원주소가 입력되지 않았습니다.");
		document.regMem.address.value = "";
		document.regMem.address.focus();
		return false;
	}
	if (document.regMem.joindate.value == '') {
		window.alert("가입일자가 입력되지 않았습니다.");
		document.regMem.joindate.value = "";
		document.regMem.joindate.focus();
		return false;
	}
	if (document.regMem.grade.value == '') {
		window.alert("고객등급이 입력되지 않았습니다.");
		document.regMem.grade.value = "";
		document.regMem.grade.focus();
		return false;
	}
	if (document.regMem.city.value == '') {
		window.alert("도시코드가 입력되지 않았습니다.");
		document.regMem.city.value = "";
		document.regMem.city.focus();
		return false;
	} 
	if (document.regMem.action.value == 'insert') {
		window.alert("회원 등록이 완료 되었습니다.");
		
	   } 
	else {
		   window.alert("회원 정보 수정이 완료 되었습니다.");
	   // 안내창
	   }

}
