# Welcome to Paw Hero Pet Adoption Website

This project was created with
- Java Spring Boot - Backend
- React - Frontend
- MySql - Database

## Getting Started
**1️⃣ React Frontend**
In the `react-frontend` project directory, you can run:

#### `npm install`

Install all the dependencies used in the project. 

#### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

**2️⃣ Java Backend**
In the `Springboot-backend` project directory, you can use Eclipse IDE to run `SpringbootBackendApplication.java`. \
The server port is configured to port 8081 in the `application.properties` file. 

To simplify the development process, two (2) roles and two (2) accounts are created automatically when the server is run. You may login to the Admin account using the credentials below: 
- Email Address: admin@admin.com
- Password: admin

For general user account, you may create your own account by signing up or use the credentials below: 
- Email Address: user@user.com
- Password: user

**3️⃣ MySql Database**
The data source url is configured to `pet_adoption_system` in the `application.properties` file. Create the schema using the following code if it is not yet exist. 

```sql
CREATE SCHEMA `pet_adoption_system` ;
use pet_adoption_system;
```

By default, there is no pet data in the database. For demo purposes, you may insert the following pet details into the database. 
```sql
INSERT INTO `pet` VALUES (1,'600.00','3 years 1 month ','Bichon Frise','Zoomba loves playing with other dogs although she tells them off if they get in her face and loves cuddles once she knows you , but don\'t growl at her as she panics. She is still wary of new people and needs slow introduction and for that reason she cant be homed with kids. In the right home Zoomba will make the most loyal and loving companion, she just needs to have a secure home. ','http://res.cloudinary.com/pawhero/image/upload/v1630576352/pawheroimages/njbwqpydwbcgat7k4wmv.png','Wodonga, VIC','Zoomba','Female','Dog'),(2,'650.00','2 years 5 months ','Boerboel','Meet Mac! He\'s one of the lucky ones to be rescued from a rural NSW pound to start his new journey in finding his forever home. He makes his foster parents laugh and is very much an easy going pup. He\'s a very loving and affectionate boy who shares his love between all the family. He draws lots of attention when out on walks because he loves to say \"hello\" and is such a stunning looking pup. Whilst he loves hanging with this family, he is also happy to just relax in his comfy bed, or patch of grass. He\'s also proven to be quite a water-baby and loves a good splash.','http://res.cloudinary.com/pawhero/image/upload/v1630577567/pawheroimages/ctlcrfjv9bfskzqnij2j.png','Wentworthville, NSW','Mac','Male','Dog'),(3,'500.00','2 years 3 months ','Collie','Hey there its Spock here. I\'m looking for a home that will allow me to be part of the family. I am only young and looking for someone who can train me and spend time with me so I can enjoy life to the fullest. I would prefer to be your one and only or if you have a mellow dog that would work too I don\'t really like dogs in my face too much its a bit scary. ','http://res.cloudinary.com/pawhero/image/upload/v1630583755/pawheroimages/cpgomppaybuaduwmglld.png','Riverhills, QLD','Spock','Female','Dog'),(4,'450.00','5 years 9 months ','Elkhound','Hi there, I\'m Radar!! I am a sweet older gentleman looking for my forever home. I would love my new family to be home more often than out as I get a little sad when your not there. When your home I will be your little shadow, following you and \'helping\' with all your daily chores.','http://res.cloudinary.com/pawhero/image/upload/v1630583685/pawheroimages/j0zbmihqbz9sjal3oqlp.png','Dakabin, QLD','RadarHeap','Male','Dog'),(5,'350.00','0 year 11 months ','Fox Terrier','Hello everyone thought I’ll introduce myself, my name is Missy. I’m an 11 month Dane X old puppy who really love humans, kids and other dogs. I’m not sure about cats as of yet! So far in life I’ve accomplished a few things; fully potty trained, can sit and give paw and most of all I can give the best slobbery kisses. My favorite things to do is running around, playing with a ball and taking long naps. But most of all is being with my humans, I understand that you guys have to go to work and I’m totally fine with that.\nI’ll just be waiting for your return with a big goofy smile on my face.','http://res.cloudinary.com/pawhero/image/upload/v1630583825/pawheroimages/b3nyilrfcsbgngwlv0av.png','Gladstone, QLD','Missy','Male','Dog'),(6,'400.00','3 years 6 months ','Japanese Spitz','He loves playing with toys and will bring balls back to play fetch. He loves his walks, he is strong but walks very well on lead. He is better suited to a home where someone is home more often and a home without children (he gets a bit over excited when they run around and throws his weight around). Trigger has not been tested with small dogs or cats. He currently sleeps through the night in a crate in his foster Mum’s bedroom. He has the short bursts of energy typical to greyhounds and spends the rest of his time lazing around. He has a big appetite and given half a chance will try to steal any unattended food. He very much loves human contact and would love to be your big sweet shadow.','http://res.cloudinary.com/pawhero/image/upload/v1630583975/pawheroimages/onk42qugnucmlnbpj0hj.png','Beaconsfield, VIC','Trigger','Male','Dog'),(7,'495.00','2 years 3 months ','Keeshond','We nicknamed him “Mr Energy”. So he is suited with a active family & best with another friendly dog. Would not suit an older person. He loves meeting other dogs, enjoys long walks. He comes when you whistle him. He still is very young & would benefit to doggie obedience classes or even agility. He still chew things if not kept busy. Loves his tucker & his occasional treat is a Pigs ear. Loves being inside & sleeps inside. Loves his cuddles. ','http://res.cloudinary.com/pawhero/image/upload/v1630584014/pawheroimages/ocsngro7j7gfafbt8v7w.png','Bribie Island, QLD','Ollie','Male','Dog'),(8,'550.00','1 year 1 month ','Lhasa Apso','This smooshy face girl is an absolute sweetheart. Gentle, placid, chilled and also very playful & energetic with the right doggy companions. Khiva enjoys many games of chase, rumbles, tuggy and bitey face with her foster siblings and will play for hours each day. Nothing quite like a long nap in the sun after an exhausting play session, and Khiva has her favourite spot on the lounge for a well earned snooze. She\'s usually side by side with her foster brother in all things dog. Super affectionate with no sense of personal space, this girl will always be wanting to sit by you (or on you) for a cuddle and pat. Deeply bonding with her humans is in her nature as is her want to be naturally protective over them. Khiva will alert at the slightest sign of trouble and tell whoever or whatever that she knows they\'re there with a deep, rumbly bark.','http://res.cloudinary.com/pawhero/image/upload/v1630584198/pawheroimages/knyyeqqhyripht6u6g3i.png','Razorback, NSW','Khiva','Female','Dog'),(9,'649.98','1 year 5 months ','Pomeranian','Gentle, sweet and engaging, his favourite pastimes are playing, eating and snoozing. He is intelligent, eager to please and highly trainable. To be happy and content, Rudi will require plenty of space to move around and exercise, especially while he\'s young. Secure fencing is a must. Preference will be given to homes where someone is around most of the time and/or there is another dog of compatible size in residence. Prior breed experience and a commitment to training will be viewed very favourably.','http://res.cloudinary.com/pawhero/image/upload/v1630584334/pawheroimages/y3nnnao8dpugzxkyy7bj.png','Warwick, QLD','Rudi','Male','Dog'),(10,'300.00','1 year 4 months ','Samoyed','Marla is a lovely blue girl who has so much love for people! She can be a little shy at first but warms up quickly and then she is affectionate and sweet. Marla can be boisterous at times, so would benefit from attending some training classes with her new person. She would love a home where she can spend time on the couch with her people - preferably after a nice daily stroll. Marla seems to enjoy the company of other dogs, so would be keen to meet a friendly male playmate. In her time at the shelter Marla has displayed certain signs of anxiety and is presently on medication.Marla is a lovely girl and could require this\nongoing care within the home and will need a owner committed to her on going needs.','http://res.cloudinary.com/pawhero/image/upload/v1630584446/pawheroimages/c0yspbtrplgh8lbmrpxo.png','Weston, ACT','Marla','Female','Dog'),(11,'400.00','1 year 11 months ','Schnauzer','Franklin was found wandering and eating garbage on the street. He was super skinny and sad. He was wearing a chain around his neck that caused some injury. He was not loved at all. We took him into our care while wondering whether his owner would come forward. Franklin was not claimed by his owner. He only weighed 20.4kg and was ravenously hungry all the time. We have had Franklin for a little more than 8 weeks - and you can see the difference in him. Good food, some love and compassion makes a huge difference! He is like a completely different dog!','http://res.cloudinary.com/pawhero/image/upload/v1630584543/pawheroimages/teticvmcvimtswsxjtxo.png','Gilgandra, NSW','Franklin','Male','Dog'),(12,'650.00','0 year 11 months ','Great Dane','The gentlest puppy in the litter, Astro\'s favourite pastimes are playing, eating and snoozing. He is intelligent, eager to please and highly trainable. He was born into a loving family environment and is well socialised. A typical Dane, he is a very chilled boy and just wants to be where his family is. To be happy and content, Astro will require plenty of space to move around and exercise, especially while he\'s young. Secure fencing is a must. Preference will be given to homes where someone is around most of the time and/or there is another dog of compatible size in residence. Prior breed experience and a commitment to training will be viewed very favourably.','http://res.cloudinary.com/pawhero/image/upload/v1630584635/pawheroimages/wcfhixfcrmfy45s5wqqt.png','Warwick, QLD','Astro','Male','Dog'),(13,'120.00','1 year 7 months ','Persian Cat','Misty is a smoochy princess. She is overly affectionate and loves to give you kisses, be kissed, loves pats, loves being picked up and loves sitting on your lap. She basically loves to be around you/with you at all times and will follow you around for love. She really is a great cat, she can be a little unsure with new people until you gain her trust but once she does it’s non stop love. She also loves to sleep with you in bed. Misty is a food thief and will steal your food any chance she gets haha! She also hates other cats so would be suited to a house where she can be the only kitty. Misty purrs constantly, likes to sit on your shoulders and honestly will be someones absolute best friend.','http://res.cloudinary.com/pawhero/image/upload/v1630585586/pawheroimages/jedhvhzgpp6syhj9e2n8.png','Mandalong, NSW','Misty','Female','Cat'),(14,'195.00','0 year 6 months ','Bengal Cat','I didn\'t have the best start in life, so I\'ve been named to be treated like a queen in my forever home! I\'ll let you call me Cleo for short. I\'m in foster care at the moment getting lots of love and warmth to help me become my best self. I would love a quiet household as my forever home. I\'m not good with dogs or kids or even women. But I have taken a fancy to my foster dad, so if you\'re a guy looking for just a quiet girl to sit with you and watch Netflix and have snacks, I\'m you\'re girl! You\'ll need lots of patience with me, I may take about a month to trust you, but when I do, I\'ll love you lots and will pur like a machine for you.','http://res.cloudinary.com/pawhero/image/upload/v1630585701/pawheroimages/hrsbfs37kus6v69spdym.png','Shenton Park, WA','Cleopatra','Male','Cat'),(15,'150.00','6 years 5 months ','Maine Coon','Sox is super affectionate like his brother Flynn. Both left on the street in a bag at 6 weeks not a great start to life. But with time lots of love and care he has turned into a loving boy. Sox loves to play, loves to be close to you. So if you can offer Sox a forever home that will love and care for him please get in touch. Sox is recommended as an inside cat only or approved cat enclosure to keep him safe.','http://res.cloudinary.com/pawhero/image/upload/v1630585776/pawheroimages/vtjnodsmdmxcpx8f58uq.png','Coopers Plains, QLD','Sox','Female','Cat'),(16,'150.00','2 years 1 month ','British Shorthair','Flynn is a little teddy bear. Loves his cuddles Loves his playtime. Loves his human. Just loves being around someone for company. He is an adorable little boy who had a rough start to life but with time, love and care he has grown into a beautiful loving little boy. A little puppy cat. Flynn is always near by – interested in what you are doing. Flynn has been vet checked had all his needles, de sexed, micro chipped, Flea and worm treated Flynn is recommended as an indoor cat only or an approved cat enclosure','http://res.cloudinary.com/pawhero/image/upload/v1630585823/pawheroimages/pz3erah20eiipngkdmnc.png','Coopers Plains, QLD','Flynn','Male','Cat'),(17,'85.00','1 year 11 months ','Ragdoll','Hi everyone my name is Theo and I would love to find my forever home with you. I love to give cuddles and and follow you around until you pat me. I love to play with balls with bells in them and love to play hide and seek in my tunnel. A screwed up piece of paper will keep me amused for hours. I love playing in any size boxes especially if you cut a few holes in it.','http://res.cloudinary.com/pawhero/image/upload/v1630585962/pawheroimages/pnai3gkwd9ouhsbzezd3.png','Wellington Point, QLD','Theo','Female','Cat'),(18,'165.00','6 years 10 months ','Sphynx Cat','Hi everyone my name is Goody. I was rescued from a small beach town in Queensland. I am very loving but not in to being picked up and carried around but I will be your ever faithful companion and do love to come and sit beside you and patted and patted and patted. I come as a bonded pair with my girlfriend Olli so we will only be adopted together.','http://res.cloudinary.com/pawhero/image/upload/v1630586015/pawheroimages/w6lq9y5ub5b5tyb5wwce.png','Hervey Bay, QLD','Goody','Male','Cat'),(19,'150.00','3 years 1 month ','American Shorthair','Hi everyone my name is Whiskey and I was saved from deathrow in a Queensland Pound. As you can see I am a big hunk of love and will keep you very warm at night in winter. I was close to 10kg when I first came to The Not Forgotten Ones Inc., but have lost quite a bit of weight and now only weigh in at 7.2kg. ','http://res.cloudinary.com/pawhero/image/upload/v1630586079/pawheroimages/o4wqsvhdz5xmmdwotj2c.png','Munruben, QLD','Whiskey','Male','Cat'),(20,'165.00','5 years 9 months ','Birman','I am a very shy little girl, but once I learn to trust you I will steal your heart. I love to play with all sorts of different toys and my boyfriend Goodi, whom I must be adopted with as a bonded pair. I was rescued from the streets on the Gold Coast after The Not Forgotten Ones Inc. had spent 2 months trying to trap my 2 brothers and I. I was quite easy to trap as I had a very badly broken leg from hip to foot and spent 7 weeks in hospital with our wonderful rescue vet, and 2 big operations later Dr Lance was able to not only save my leg, he also turned me from a wild, scared little girl to a wonderful loving little girl in the 7 weeks I was in hospital with him.','http://res.cloudinary.com/pawhero/image/upload/v1630586163/pawheroimages/adqg4efkglgtiqe600vt.png','Hervey Bay, QLD','Olli','Female','Cat'),(21,'100.00','8 years 2 months ','Toyger','Cyrus is a sweet, big, shy older boy. His time on the streets was hard - he still has a little scab on his nose that is healing, has almost no teeth and is FIV+. Amazingly, he is a big and beautiful docile boy who is comfortably settling into indoor life. Given his fair features and diagnosis, he would be better suited to an indoor life only from now on. Cyrus accepts all over body pats as long as your slow and gentle, he may give little hisses but it’s all for show as he’s never shown any signs of aggression. Being a little shy, he may hide at first but given time he will come out of his shell, he would enjoy a nice heated bed after living in the cold dirt for so long. He’s an expert with a litter box and very neat.','http://res.cloudinary.com/pawhero/image/upload/v1630586257/pawheroimages/z4brtmjgwonvohvt1pk9.png','Orelia, WA','Cyrus','Male','Cat'),(22,'100.00','2 years 1 month ','Kinkalow','For most of my life, as far back as I can remember, I lived very happily with my skin daddy until one day he just didn’t come home. I waited and waited as I knew how much he loved me and I loved him - he wouldn’t just leave without me, people came and said something I didn’t understand about him going to heaven, and that I would have to be surrendered to the pound. As you can imagine that was very scary, but the lovely lady there fed me and was so kind and reassuring. She told me not to worry and that someone from Perth Rescue Angels was coming to get me and that I would have lots of fun and love.','http://res.cloudinary.com/pawhero/image/upload/v1630586330/pawheroimages/usywlpsyqcycgcnwroav.png','Secret Harbour, WA','Nash','Male','Cat'),(23,'350.00','0 year 4 months ','Havana Brown','This fluffy, sweet faced kitten loves to cuddle with you! Once this little cutie becomes comfortable in your company, he will give you plenty of smooches and all of the love that you can imagine. Toby is very playful and loves to interact with all his kitten toys. He also enjoys gazing out the window, watching the world go by in the sunny Springtime. This friendly boy will make himself known with little trills and sweet meows, just for you. When he is content, he will also give off the loudest purr that will make you smile from ear to ear. At night times, he loves to be close to you, nestled in close for your comfort and warmth ','http://res.cloudinary.com/pawhero/image/upload/v1630586406/pawheroimages/bhtgcqklsrbc6j4xv0fo.png','Carrum Downs, VIC','Toby','Male','Cat'),(24,'200.00','1 year 2 months ','Burmilla','I came into the care of Perth Rescue Angels all the way from Newman! When I was found, I was homeless and on the streets with my four kittens, so I was very happy that we were able to make our way to the city in search of a better life. Now my kittens are all big and grown and I\'m hoping it\'s time for me to find my happily ever after! Just like most cats, food is definitely the way to my heart. I love chicken and salmon! I also like crunchy biscuits and Dine dinners, but I\'ll even be happy with cooked mince too! Yum yum yum! I\'m also a very clean and polite housemate and I\'m very good at using my litter tray.','http://res.cloudinary.com/pawhero/image/upload/v1630586517/pawheroimages/cymzqdwovljnem43ne4p.png','Rockingham, WA','Venus','Male','Cat');
```
