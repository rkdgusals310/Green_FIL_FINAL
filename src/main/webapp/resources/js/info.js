
/* 알림 모달창 생성 함수 */
function showAlert(message) {
	const modal = document.createElement('div');
	modal.style.position = 'fixed';
	modal.style.top = '20%';
	modal.style.left = '50%';
	modal.style.transform = 'translateX(-50%)';
	modal.style.padding = '20px';
	modal.style.background = 'rgba(0, 0, 0, 0.8)';
	modal.style.color = '#fff';
	modal.style.borderRadius = '5px';
	modal.style.zIndex = '1000';

	modal.textContent = message;

	document.body.appendChild(modal);

	// 0.5초 뒤 모달 사라지게
	setTimeout(function() {
		modal.remove();
	}, 500);
}