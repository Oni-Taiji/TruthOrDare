package android.example.truthordare.repository

import java.util.ArrayList

object Repository {

    private var repoQuestions = ArrayList(arrayListOf(
        "Your weirdest google query? ",
        "Would you rather walk around naked or let those around you read all your innermost thoughts?",
        "Do you eat food that fell on the floor? ",
        "Do you sing in the shower? ",
        "Do you have a stuffed toy that you take to bed with you? ",
        "Do you drool in your sleep?",
        "Do you talk in your sleep?" ,
        "What's the best song to shower to? ",
        "Have your parents been called to school? ",
        "Did you lie to your parents about your studies? ",
        "What color are your underpants?",
        " Your last message? ",
        "If every uncensored word shortened your life by one day, how long would you live? ",
        "Do you like talking to cab drivers about life? ",
        "Describe the strangest dream you've ever had?",
        "Stupidest thing you've ever done? ",
        "Did you get nicknames as a kid? ",
        "Is the dish you cook so awful that it's amazing? ",
        "What app on your phone takes up the most of your time? ",
        "Have you been pretending to be sick to skip work? ",
        "You tell your boss you're sick and then you meet him at a party. Your excuse? ",
        "Do you like to dance at home when no one is looking? ",
        "What do you sleep in? ",
        "How many selfies do you have to take to get something decent? ",
        "Would you rather lose 10 pounds or gain weight? ",
        "Your most useless skill? ",
        "Most useless information in your head? ",
        "Have you ever had to try pet food?",
        "What job would you never take? ",
        "Going back in time, what act of yours would you erase? ",
        "When was the last time you cried and why? ",
        "Your greatest fear? ",
        "If you had a few months to live, how would you spend it? ",
        "Do you like spending time with your parents? ",
        "If you had money for plastic surgery, what would you change about yourself? ",
        "Have you ever wanted to be the most popular person in school? ",
        "Do you want to have children in the future? ",
        "Lots of money and loneliness or average income but a happy family? ",
        "Is there a person you hate? ",
        "A message that broke your heart? ",
        "Will you go on a serious deception for a friend? ",
        "Jealous of your best friend for his other friends? ",
        "Name five virtues you have that no one else knows about. ",
        "Name five faults you have that no one knows about."
    ))

    private var repoActions = ArrayList(arrayListOf(
        "Take an ugly selfie and post it as a profile picture.",
        "Take your socks off with your teeth.",
        "Go to your neighbor's house and ask him for a glass of sugar.",
        "Let the group decide what object you need to brush your teeth with.",
        "Write your name in the air with your tongue.",
        "Open the front door and howl like a wolf for 30 seconds.",
        "Let the person sitting next to you tape up any part of your body and then take it off.",
        "Put some honey on your nose and sprinkle some flour on top.",
        "Talk really loud until the next round, like no one can hear you.",
        "Call a guy/girl you like.",
        "Have a glass of brine.",
        "Talk to your pillow like it's your lover/s.",
        "Pretend to be a bird and try eating breakfast cereal with your mouth without your hands.",
        "Make peace with your hand.",
        "Let someone style your hair and walk around with that hairstyle for the rest of the day.",
        "Use your comb as a microphone every time you talk to someone.",
        "Cover one of your front teeth in black. (You can use eyeliner).",
        "Pretend to cry.",
        "Make unpleasant noises when you eat or drink.",
        "Crouch your eyes when you talk.",
        "Talk without covering your mouth.",
        "Act like an animal chosen by the participants.",
        "Argue with the wall.",
        "Continuously water your face with a water pistol while talking.",
        "See how many grapes will fit in your mouth.",
        "Hiccup between every word you say.",
        "Burp the alphabet.",
        "Draw something on your face with a highlighter.",
        "Eat a teaspoon of mustard.",
        "Spin around yourself 10 times and try to walk straight.",
        "Eat a raw egg.",
        "Stand up and do jumping jacks until it's your turn again.",
        "Run down the street and yell, 'I've got lice!",
        "Stop your car in the street and tell the driver that his car's wheels are spinning.",
        "Pick your neighbor's nose.",
        "Scatter a handful of lego pieces on the floor and walk around barefoot.",
        "Sit on your knees for an hour.",
        "Call a stranger and tell him a secret.",
        "Let someone pour ice down your scruff.",
        "Let the band members kick you in the butt.",
        "Pick your neighbor's nose.",
        "Jump in the trash can.",
        "Write someone a message Hey. Every time someone replies to you, write Hey. Repeat it ten times. On the 11th time, reply Hi.",
        "Let someone look up your browser search history for a minute.",
        "Write a letter to your doctor describing the embarrassing rash you have and post it on social media.",
        "Smell the armpit of the person sitting next to you and describe the smell to the rest of the participants.",
        "Wear your underwear over your clothes and wear it that way for the rest of the game.",
        "Dig through the trash can and name anything you find.",
        "Coat your hands in food coloring and don't wash it off for 10 minutes.",
        "Call someone on Skype, Viber or Whatsapp and pick your nose while you're talking.",
        "Take off your laundry and throw it in the trash.",
        "Lick mayonnaise off your neighbor's finger."
        ))

    private var noAgain = ArrayList<Int>()
    fun endOfPlay() {
        noAgain = ArrayList()
    }

    fun getQuestion() :String{
        val index: Int = (0..42).random()
        if (noAgain.count() == repoQuestions.count()) {
            noAgain.clear()
        }
        if (!(noAgain.contains(index))) {
            noAgain.add(index)
            return repoQuestions[index]
        }
        return getQuestion()
    }

    fun getAction() :String{
        val index: Int = (0..51).random()
        if (noAgain.count() == repoActions.count()) {
            noAgain.clear()
        }
        if (!(noAgain.contains(index))) {
            noAgain.add(index)
            return repoActions[index]
        }
        return getAction()
    }

}