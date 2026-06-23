document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('signupForm');
  const errorMsg = document.getElementById('errorMsg');

  form.addEventListener('submit', async (e) => {
    e.preventDefault();

    const data = {
      name: form.name.value,
      username: form.username.value,
      email: form.email.value,
      password: form.password.value,
    };

    try {
      const res = await fetch('/users', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data),
      });

      if (res.ok) {
        window.location.href = '/login';
      } else {
        const err = await res.json();
        errorMsg.textContent = err.message || 'Signup failed';
        errorMsg.classList.remove('hidden');
      }
    } catch {
      errorMsg.textContent = 'Network error. Please try again.';
      errorMsg.classList.remove('hidden');
    }
  });
});
