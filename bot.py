# A simple demonstration of how you can use this as a bot, provided for example.

import discord
import random

client = discord.Client()

# Generate a random math question
def generate_captcha():
    num1 = random.randint(1, 10)
    num2 = random.randint(1, 10)
    operator = random.choice(["+", "-"])
    captcha = f"{num1} {operator} {num2} = ?"
    return captcha

# Validate the user's input against the CAPTCHA answer
def validate_captcha(user_input, captcha_answer):
    return user_input == captcha_answer

# Refresh the CAPTCHA
def refresh_captcha():
    captcha_text = generate_captcha()
    return captcha_text

# Event listener for when the bot is ready
@client.event
async def on_ready():
    print(f"Logged in as {client.user}")

# Event listener for when a message is sent
@client.event
async def on_message(message):
    if message.author == client.user:
        return

    if message.content.startswith("!captcha"):
        captcha_text = generate_captcha()
        await message.channel.send(f"Please solve the following math problem: {captcha_text}")

        def check(msg):
            return msg.author == message.author and msg.channel == message.channel

        try:
            user_input = await client.wait_for("message", check=check, timeout=10.0)
        except asyncio.TimeoutError:
            await message.channel.send("Time's up! Please try again.")
        else:
            if validate_captcha(user_input.content, eval(captcha_text.split("=")[0])):
                await message.channel.send("CAPTCHA validation successful!")
            else:
                await message.channel.send("CAPTCHA validation failed. Please try again.")

client.run("YOUR_BOT_TOKEN")
