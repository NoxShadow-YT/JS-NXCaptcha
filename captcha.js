// Generate a random math question
function generateCaptcha() {
  var num1 = Math.floor(Math.random() * 10) + 1;
  var num2 = Math.floor(Math.random() * 10) + 1;
  var operator = Math.floor(Math.random() * 2) === 1 ? "+" : "-";
  var captcha = num1 + " " + operator + " " + num2 + " = ?";
  return captcha;
}

// Validate the user's input against the CAPTCHA answer
function validateCaptcha() {
  var userInput = document.getElementById("captchaInput").value;
  var captchaAnswer = eval(document.getElementById("captchaText").textContent);

  if (userInput == captchaAnswer) {
    alert("CAPTCHA validation successful!");
  } else {
    alert("CAPTCHA validation failed. Please try again.");
  }
}

// Refresh the CAPTCHA
function refreshCaptcha() {
  var captchaText = generateCaptcha();
  document.getElementById("captchaText").textContent = captchaText;
}

// Attach event listeners to the relevant elements
document.getElementById("submitButton").addEventListener("click", validateCaptcha);
document.getElementById("refreshButton").addEventListener("click", refreshCaptcha);

// Generate the initial CAPTCHA
var captchaText = generateCaptcha();
document.getElementById("captchaText").textContent = captchaText;
