document.addEventListener('DOMContentLoaded', function () {
    const signupForm = document.querySelector('section');
    signupForm.style.opacity = 0;

    setTimeout(() => {
      signupForm.style.transition = 'opacity 1s ease-in-out';
      signupForm.style.opacity = 1;
    }, 500);

    const signupButton = document.querySelector('button');
    signupButton.addEventListener('click', function () {
      const emailInput = document.querySelector('input[type="email"]');
      const passwordInput = document.querySelector('input[type="password"]');
      const confirmPasswordInput = document.querySelector('input[type="password"][name="confirm-password"]');
      const isValid = emailInput.checkValidity() && passwordInput.checkValidity() && confirmPasswordInput.checkValidity();

      if (!isValid) {
        signupForm.classList.add('shake');

        setTimeout(() => {
          signupForm.classList.remove('shake');
        }, 1000);
    } else {
      showModal();
    }
  });

  function showModal() {
    const modal = document.createElement('div');
    modal.style.position = 'fixed';
    modal.style.top = '0';
    modal.style.left = '0';
    modal.style.width = '100%';
    modal.style.height = '100%';
    modal.style.background = 'rgba(0, 0, 0, 0.7)';
    modal.style.display = 'flex';
    modal.style.justifyContent = 'center';
    modal.style.alignItems = 'center';
    modal.style.zIndex = '1000';

    const modalContent = document.createElement('div');
    modalContent.style.background = '#fff';
    modalContent.style.padding = '2rem';
    modalContent.style.borderRadius = '10px';
    modalContent.style.boxShadow = '0 5px 15px rgba(0, 0, 0, 0.3)';
    modalContent.style.textAlign = 'center';

    const message = document.createElement('p');
    message.innerText = 'Cadastro realizado com sucesso!';
    message.style.fontSize = '1.5rem';
    message.style.color = '#333';
    modalContent.appendChild(message);

    const okButton = document.createElement('button');
    okButton.innerText = 'OK';
    okButton.style.marginTop = '1rem';
    okButton.style.padding = '0.5rem 2rem';
    okButton.style.border = 'none';
    okButton.style.background = 'linear-gradient(135deg, #ff9a9e, #fad0c4)';
    okButton.style.borderRadius = '5px';
    okButton.style.color = 'white';
    okButton.style.cursor = 'pointer';

    okButton.addEventListener('click', () => {
      window.location.href = '/req/login';
    });

    modalContent.appendChild(okButton);
    modal.appendChild(modalContent);
    document.body.appendChild(modal);
  }
});
