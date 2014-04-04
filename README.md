BatterBot
====================================
Purpose:

The purpose of this code is to provide a basic chatter bot engine.
--------------------------------
Using the code:

The old version of this code is only designed to be used through the eclipse console. The code can then be used by creating a project in eclipse, bringing in the relevant files, and running the BatterBotDriver class, which contains a main method which will initiate the conversation cycle. You can create your own chatter bot by creating a method that will create new Response Templates, and calling the cycle() method.

The new version of this code also contains a simple GUI that allows the users to write and view text.
---------------------------------
Simple System Overview:

We begin by examining the flow of data by defining five main components in our system. We have the Language Processor, the Response Selector, the Response builder, and the IO controller. Another critical component of the system is the Response Template class, which we discuss more in the next section. Using these components, we can construct the basic cycle observed when the user enters an input string. 

The program starts with the GUI reading the user input. This input String is the given to the Language Processor, which extracts from the input all of the recognized keywords. These matched keywords are then passed to the Response Selector. The Response Selector ranks all of the relevant response templates, selecting the one with the most matched keywords. This Response Template is then passed to the Response Builder. Each Response Template contains a String with some blanks and possible variable substitutions. The Response Builder then fills in these blanks with the variable substitutions, and hands the complete string to the GUI to be printed. The cycle then repeats.
-----------------------------------
BatterBotDriver:

We use a driver class BatterBotDriver which contains all of the components needed for the Chatter Bot. This class also stores the main function cycle() which iterates through the user input and chatter bot response cycle. Additionally, there is a method setup(), which can be used to load our sample Batter Bot Response Template files.
---------------------------------------- 
IO Console:

The current IO class is very simple, and is simply used to read user input from the eclipse console, and then print the chatter bot responses. 
-----------------------------------------
Language Processor:

Our implementation of the Language Processor is relatively simple. The Language Processor takes in the user input as a String. The Language Processor then loops through a list of all of the known keywords, and searches through the user input looking for each one. Every keyword that is found is then stored in a list, which is passed to the Response Selector. 

Two external language toolkits were added to the language processor. Both libraries are from the Stanford Natural Language Processor.  The first library is the Parts Of Speech (POS) tagger.  The second library added is the Named Entity Recognition (NER) classifier.

The Language Processor automatically pulls out any proper nouns, base verbs, locations, or organizations in the input, and commits them to memory.  This allows for more interesting responses to be constructed.
--------------------------------------------
POS Tagger:

The POS tagging library for the Stanford Toolkit is a library that allows tagging each word in a given string.  The classifications include various verb classifications, nouns, proper nouns, prepositions....etc. The output from the tagger is a string with "_" followed by the words type appended to each word. EX: "Bryce"-->"Bryce_NNP", "_NNP" being the code for a proper noun.
-------------------------------------------- 
NER Classifier:

The NER classifying library is a library that allows certain words, particularly nouns, to be classified from a given string. Some classifications include locations, and organizations.  The output from the classifier is the input string with "/" followed by the location appended to words of interest.  EX: "Kelowna"-->"Kelowna/LOCATION", "/LOCATION" being the code for a location.
--------------------------------------------
Response Selector:

The Response Selector contains a reference to a Hash Table storing pointers to all of the Response Templates. The keys for the hash table are the keywords, and the values are then the pointers to the Response Templates. This allows for quickly finding all of the relevant Response Tables based on a set of found keywords. 
---------------------------------------------
Response Builder:

Given a Response Template as input, the Response Builder fills in the canned sentence with its variable substitutions and returns the response as a string. A variable substitution may optionally come from the memTable, which contains previous user input. 
------------------------------------------------
MemTable:

This is a dictionary data structure used to store previous user input. For example, the key may be “Name” and the value “John Doe”. When the question “What is your name?” Is asked, the response would then be parsed and stored in the memTable. 
-------------------------------------------------- 
Response Template:

The Response Template is a class used to store the ‘canned’ sentences and their variable substitutions. Each Response Template will contain:
-	An output sentence with possible blanks to be filled in
-	The Array of buckets, which contain the variable substitutions
-	 A list of key words that will trigger that response to be selected
Additionally, a Response Template may contain a scaleRules function definition, which allows for more complicated selection rules to be defined. This function should return a value that will multiply the normal ranking determined by the number of relevant keywords. For example, supposing that the given response should only be said once, the function scaleRules could return 1 if the response has not yet been used and a value of 0 if the response already has been used. Alternatively, this function could be used to increase the weight of the responses ranking by using a number larger than 1. This should be used with caution. 
If a Response Template is asking a question of the user, for example, “What is your phone number?” then the response Template must also define and additional step for interpreting the following user input. In our example, this would mean extracting the phone number from the response. The Response Template then also needs to have a memTable key, called memEntry, which is the key that will be used to store that user response in the memTable. 
-----------------------------------------------------
KeyWordList:

We have created our own class, the KeyWordList, which is used to store a list of keywords. This class is very simple, and was designed to facilitate the integration of new features in the future. Currently it simply wraps an array of Strings. 
-----------------------------------------------------
Batman Convo:

This is the GUI class. Running this class results in the GUI version of the program.  The GUI was constructed using the Eclipse plugin Window Builder.  The theme of the GUI is the traditional Batman colours: black, grey, and yellow.
-------------------------------------------------------
Translation

This is a class that implements the Google Translate API.  This class includes a constructor as well as a method to translate the input from french to english, and from english to french.  This class is used by the language processor and response builder to allow the conversation to be in French.
-------------------------------------------------------
Tweet:

This is a class that implements the twitter API.  This class allows you to search the 20 most recent tweets from an given twitter handle, of the form @example.  Tweet class contains a method for getting tweets given a string of the twitter handle so @example would be passed as "example"
--------------------------------------------------------
Wolfram:

This is a class that implements the Wolfram-Alpha API.  This class allows you to search for synonyms of a given word using Wolfram, it also parses the return data and puts any synonyms in a String array.
===========================================================
ADDED FEATURES:
1. Google Translate API:  Use of this API in the Translation.java class allows the conversation to take place in French.  It could also easily be expanded to include other languages.  The overall system looks for a french flag, when this flag is raised the language processor translates the input from french to english before processing it, and the response builder translates the response back from english to french immediately before returning it.  Which all to say that the processing of the conversation is still done in english.
	EX:  YOU: qui est votre pere

		Batman: Je ne veux pas parler de mon père . 
		
2. Twitter API:  Use of this API in the tweet.java class allows searching of the 20 most recent tweets of a given (public) twitter handle, in this case @TheBatman.  The system uses this API to display the tweets in the GUI and also to allow the user to ask batman about some of those tweets.
	EX: YOU: You fight sharks?

		Batman: Yeah, I fight sharks from time to time...

3. Wolfram-Alpha API:  Use of this API in the Wolfram.java class allows querying Wolfram-Alpha for synonyms of the given word.  The system uses this API to search for synonyms to words in the user input in the case that nothing else generates a response.  These synonyms are then checked against the existing keywords.
	EX: YOU: jump

		Batman: I can jump pretty damn high

		YOU: bound

		Batman: I can jump pretty damn high...As I've already told you. My time is precious.
		