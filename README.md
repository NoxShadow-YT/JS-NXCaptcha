# JS-NXCaptcha

## Project Description
This project provides a simple JavaScript file that can be added to a website to implement a basic CAPTCHA. The CAPTCHA is used to verify if the user is human or not and prevent automated bots from accessing the website and wasting resources. The CAPTCHA can be either an alphanumeric string or a math question, depending on the implementation chosen.

## Project Usage
To use this JavaScript file, add it to your website and include it in your HTML file. You can customize the appearance and behavior of the CAPTCHA form by modifying the HTML and CSS as needed. The JavaScript code provides three functions: `generateCaptcha()`, `validateCaptcha()`, and `refreshCaptcha()`. The code attaches event listeners to the relevant elements in the HTML file, such as the submit button and refresh button, to trigger the validation and refresh functions. The initial CAPTCHA is generated when the page loads.

## Profession / Nerds
For more advanced users, you can customize the range of numbers used in the math question by modifying the Math.random() and Math.floor() functions. You can also add additional features, such as using special characters in the CAPTCHA code or changing the length dynamically, to enhance the CAPTCHA's effectiveness.
You can choose to use this script as a basis for a Discord Bot, check `bot.py` for more info, or if you know how to compile a Minecraft Plugin, you can start off from my `Main.java` script in `src` folder.
