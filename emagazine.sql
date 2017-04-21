/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.0.67-community-nt : Database - emagazine
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`emagazine` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `emagazine`;

/*Table structure for table `adminrecord` */

DROP TABLE IF EXISTS `adminrecord`;

CREATE TABLE `adminrecord` (
  `name` varchar(50) default NULL,
  `admin_id` varchar(20) default NULL,
  `pass` varchar(30) default NULL,
  `repass` varchar(30) default NULL,
  `email` varchar(30) default NULL,
  `dob` varchar(20) default NULL,
  `occupation` varchar(30) default NULL,
  `prinum` varchar(20) default NULL,
  `secnum` varchar(20) default NULL,
  `add` mediumblob,
  `username` varchar(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `adminrecord` */

insert  into `adminrecord`(`name`,`admin_id`,`pass`,`repass`,`email`,`dob`,`occupation`,`prinum`,`secnum`,`add`,`username`) values ('Anubhav Gupta','683479271','a123','a123','anubhavguptacse@gmail.com','2015-07-15','Student','9782464764','1412703888','Anubhav Gupta.....','anubhav');

/*Table structure for table `alumnirecord` */

DROP TABLE IF EXISTS `alumnirecord`;

CREATE TABLE `alumnirecord` (
  `name` varchar(15) default NULL,
  `alumni_id` varchar(20) NOT NULL,
  `pass` varchar(10) default NULL,
  `repass` varchar(10) default NULL,
  `email` varchar(30) default NULL,
  `dob` varchar(10) default NULL,
  `branch` varchar(30) default NULL,
  `passyr` varchar(5) default NULL,
  `occupation` varchar(50) default NULL,
  `prinum` varchar(10) default NULL,
  `secnum` varchar(10) default NULL,
  `add` mediumblob,
  `username` varchar(50) default NULL,
  PRIMARY KEY  (`alumni_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `alumnirecord` */

insert  into `alumnirecord`(`name`,`alumni_id`,`pass`,`repass`,`email`,`dob`,`branch`,`passyr`,`occupation`,`prinum`,`secnum`,`add`,`username`) values ('Ankushree Gupta','295791316','a123','a123','anku@gmail.com','2015-07-14','Computer Science Engineering','2010','MBA Student','1234567890','1234568790','Ankushree Gupta....','anku');

/*Table structure for table `articlecategory` */

DROP TABLE IF EXISTS `articlecategory`;

CREATE TABLE `articlecategory` (
  `category` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `articlecategory` */

insert  into `articlecategory`(`category`) values ('select'),('Academics'),('Health'),('College'),('New Environment');

/*Table structure for table `articleclass` */

DROP TABLE IF EXISTS `articleclass`;

CREATE TABLE `articleclass` (
  `class` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `articleclass` */

insert  into `articleclass`(`class`) values ('select'),('Informative'),('Motivation');

/*Table structure for table `articleinfo` */

DROP TABLE IF EXISTS `articleinfo`;

CREATE TABLE `articleinfo` (
  `no` varchar(20) default NULL,
  `class` varchar(50) default NULL,
  `category` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  `date` varchar(30) default NULL,
  `description` blob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `articleinfo` */

insert  into `articleinfo`(`no`,`class`,`category`,`type`,`date`,`description`) values ('45246','Informative','Academics','Make Different','2015-07-05',' GIVE YOURSELF A BREAK\r\n\r\nJust because your math placement exam told you that you could handle the Calculus I curriculum, doesnâ??t mean you should hit the equations if youâ??re an art history major. If your advisor says all you need is Intro to Statistics, TAKE INTRO TO STATISTICS. Save the hard work for the classes in your major and use your gen-eds as GPA boosters. Youâ??ll thank yourself later.'),('32752','Informative','Academics','Make Different','2015-07-06','KEEP IT RELEVANT\r\n\r\nMost schools offer a wide variety of out-of-the-box classes that will satisfy your requirements, but if you canâ??t relate the information youâ??ll learn to your major, you may want to reconsider your choice. Spending the semester revisiting your inner second grader in The History of Dinosaurs would be amazing, but unfortunately, the only people who need that knowledge would be future paleontologists. Next option, please.'),('43246','Informative','Academics','Make Different','2015-07-07','KEEP IT INTERESTING\r\n\r\nEven if the class is as simple as Intro to Just Showing Up to This Lecture Hall, if youâ??re not interested in the topic, you wonâ??t pass. Try to find a class that relates to your major or interests. If youâ??re an aspiring online media guru, up your skills with an easy introductory programming course. You might even gain some skills along with an easy â??A.â??'),('15551','Informative','Academics','Make Different','2015-07-08','CONSULT THE BESTIES\r\n\r\nYouâ??re a business major, and your buddy is a future chemical engineer, but you both still havenâ??t taken English. This could be your one chance to have a class together, even if it is a super dull one. Suffering through gen eds is always better with a friend. If you and your pals donâ??t have any overlapping requirements, you can still use them as a resource to help you decide which class to take. Debating between whether to take Intro to Anthropology or Intro to Sociology? See which one your friends took, ask what they thought of the class and use their opinion to make an informed decision.'),('59847','Informative','Academics','Make Different','2015-07-08','MAKE NEW FRIENDS\r\n\r\nYour friends couldnâ??t fit econ into their schedules, and youâ??re never going to make it through this 300-person lecture alone. Thereâ??s got to be someone seeking new friendship here, right? Look around at whoâ??s in your class and sit next to someone interesting looking. It could be the girl from your dorm who you never really introduced yourself to, the boy you see in the dining hall every day at lunch or just a random stranger. You need a few study buddies and everyone needs some new friends, so why not start here?'),('96459','Informative','Academics','Make Different','2015-07-09','OVERLAP THOSE REQS\r\n\r\nClasses can meet more than one graduation requirement, so do your research when choosing classes and make this a priority when assembling your schedule. Waking up for an 8 a.m. psychology lecture every day isnâ??t ideal, but if it counts as both a natural science and a social science, itâ??s better than having to squeeze in two extra classes next semester.  Gen eds are more bearable if you just get them over with as soon as humanly possible.'),('71812','Informative','Health','Mind and Body','2015-07-09','Learning to Love My Body and Myself\r\n\r\nPicking a major feels like the most important decision of your life. According to everyone including your parents and the nosy pastor at church, what you study in college will determine your career path, your life purpose and whether you will be happy and successful. Itâ??s hard not to feel the pressure if you scroll through a â??Top 10 Majors that Will Guarantee You Succeed in Lifeâ?? article and not feel attached to any one of them â?? or freak out if something youâ??re interested in makes the â??Least Employable Majorsâ?? list.\r\n\r\nEmily Kennelly, an advisor at Florida Stateâ??s career center, said that you can relax a little on this front. â??Employers hire people, not majors,â?? Kennelly said. Itâ??s more about recognizing your strengths and skills and being able to market them to an employer.\r\n\r\nYou donâ??t have to major in business to do business â?? you just need to have the related skills for the job. â??Depending on the industry you plan to pursue, your undergraduate major might not matter as much as your transferable skills, college experiences and how you convey or market this information to an employer. Now, if you want to be a nurse â?? you probably need to major in nursing,â?? Kennelly said.\r\n\r\nBut most majors â?? and careers â?? are flexible. â??75 percent of careers donâ??t require a particular major. Most occupations are looking for a certain skill set,â?? said Linda Burns, an advisor for undecided students at Florida State.\r\n\r\nShe called such talents â??soft skills;â?? theyâ??re not the skills you learned in trigonometry; but instead, theyâ??re perseverance you learned when your homework got hard, leadership skills from your Environmental Awareness club or what you learned when you volunteered at that childrenâ??s camp last summer. Learning the most effective way to corral a gaggle of screaming children into a dining hall can accidentally teach you things like â??patienceâ?? and â??people skillsâ?? that potential employers find appealing.\r\n\r\nBurns said youâ??d be very lucky to be certain with your major at 18-years-old. She advised exploratory and questioning students to, â??Live life. Collect experiences. You never know what experience you have is going to put you in the direction of a career.â?? Even if you think youâ??ve got it all figured out as soon as you step onto that college campus, youâ??ll never be able to predict how your college years will shape and challenge you.\r\n\r\nSeeking out adventures and trying new activities will give you more and more chances to learn more about yourself. If youâ??ve never gone hiking, you might discover that you love looking at plants and annoying your friends by reciting their scientific names. This could lead to a great volunteer gig at a nature center which would give employers insight into your values. Or youâ??ll realize that if your job doesnâ??t involve air conditioning, youâ??ll have to cross it off the list.\r\n\r\nBurns said that the biggest mistake students make is having a lack of knowledge before picking a major â?? both self-knowledge and knowledge of what the major involves. â??Thatâ??s a lost piece sometimes, students donâ??t consider what major is right for them.â?? Kennelly said many students pick their major because their parents told them to instead of choosing it based on their own skills and values.\r\n\r\nSo when picking a major, think about who YOU are. Are you good at math? Are you a good listener? Are you a bad driver? All of these things will lead you to a major that suits YOU.  â??We need to do what we are,â?? Burns said.'),('19741','Informative','College','Skill you learn','2015-07-10','Crying: The One Skill You Really Learn in College\r\n\r\nMaybe itâ??s because Iâ??m a girl. Maybe itâ??s because Iâ??m a girl in a sorority. But it seems the one thing no one told me to expect in college is the rampant crying epidemics. From the dorm halls to the bathroom stalls, girls seem to be crying everywhere I turn.\r\n\r\nBut donâ??t let me give you the impression that this is a phenomenon I only watch like a National Geographic special. Iâ??ve participated in the art of teary-eyed melancholy on more than one occasion. Iâ??ve cried when my workload became too much to handle. Iâ??ve cried with my roommate over boys and break-ups. Sometimes I cry when Iâ??m HAPPY. And I wonâ??t even get into that one time I cried to a stranger at a house party when he put on my favorite Blink 182 album, throwing me into a fit of high school nostalgiaâ?¦ Itâ??s gotten to a point now that my friends and I will plan an entire evening, down to the perfect Nicholas Sparks movie and carton of ice cream, with the single aim at having a solid sob sesh. We call them LIAOâ?? â??let it all outâ??â?? nights.\r\n\r\nHow did we find ourselves on this level of One Tree Hill-worthy drama? It turns out that living on our own for the first time while juggling academics, jobs and social lives has made the â??best four years of our livesâ?? more emotionally-draining than any of us could have predicted. Our mascara-stained cheeks have put our $30 Clinique blush kits to shame. Our youthful glows have been dimmed by heartbreaks and hangovers. College has reduced us to ugly-crying memes, and I blame it all on expectations.\r\n\r\nThe concept of college is too often sketched in the image of nirvana. Before we enter the golden gates of our chosen university, we are promised intellectual enlightenment, life-long friendships, outrageous partying and, of course, the job offer of our dreams the day we step out of our graduation gowns.\r\n\r\nReality soon smacks us in the face: College is not a Drake music video. Itâ??s real life. And itâ??s imperfect, like Donald Trumpâ??s attempt at a presidential campaign. Although Iâ??ve enjoyed my fair share of life-changing professors, amazing friends and killer parties, all the glamour that college has had to offer has come with an equal dose of dog crap.\r\n\r\nIf Iâ??m going to hold onto one expectation for the rest of my college career, it will be challengesâ?? I see you and say welcome. The more time I spend in the fetal position under a mountain of tissues, the more I lose sight of everything I actually learn from my disappointments.\r\n\r\nLike that time my photography professor bashed my first project that actually meant something to me, I was devastated. But instead of letting her faux expertise change me, I became a rebel and dedicated every ensuing project to pushing her buttons as far as I could.\r\n\r\nAnd there was that other time I had a massive crush on a guy who I thought was my own Joseph Gordon-Levitt in 500 Days of Summer 2.0, until he revealed himself as a massive jerk by our first date function. I didnâ??t allow myself to be possessed by some obsessive hope that he would return to being the awesome guy I was into; I accepted the fact that he wasnâ??t who I thought he was and stopped answering his texts. When I look back on my disappointments, I say â??God Bless.â?? When I didnâ??t get what I wanted out of my college nirvana, I gained a little more wisdom and a little more bravery that prepared me for my next battle.\r\n\r\nAs my friends and I continue on our struggle bus journey, I nod to my long-beloved Blink bros. â??So I guess this is growing up.â??'),('61942','Motivation','New','Skill you learn','2015-07-10','PUT YOURSELF IN A NEW ENVIRONMENT\r\n\r\nSometimes your writerâ??s block is not so much an illness as it is a symptom of being stuck in a rut. How long have you been staring at that blank Word document? When was the last time you went outside? Get coffee at somewhere other than the campus Starbucks. Itâ??s never too late to change, and you might find that a simple shaking up of your everyday routine relieves your writerâ??s block and produces some immediate inspiration.');

/*Table structure for table `articletype` */

DROP TABLE IF EXISTS `articletype`;

CREATE TABLE `articletype` (
  `type` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `articletype` */

insert  into `articletype`(`type`) values ('select'),('Make Different'),('Mind and Body'),('Skill you learn');

/*Table structure for table `commentinfo` */

DROP TABLE IF EXISTS `commentinfo`;

CREATE TABLE `commentinfo` (
  `articleno` varchar(50) default NULL,
  `userid` varchar(20) default NULL,
  `usertype` varchar(20) default NULL,
  `comment` blob,
  `username` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `commentinfo` */

insert  into `commentinfo`(`articleno`,`userid`,`usertype`,`comment`,`username`) values ('45246','683479271','Admin','I finally found inspiration, thanks to your invaluable work. I must admit i was stuck in my second assignment of my creative writing distance learning course from Writers bureau UK. I reside in Nairobi, Kenya','anubhav'),('45246','195392742','Student','Thanks for your good work.I have really benefited in my research.Iam an up-coming journalist student at Mt Kenya university in Thika.Keep it up!','archit'),('43246','295791316','Alumni','Iâ??v bn teaching feature & magazine article writing for some time now, but I find your post quite insightful.\r\nKudos.','anku'),('45246','295791316','Alumni','Great post! Thanks for the information, very helpful. Btw, I discovered your site and blog last week and Iâ??m quite impressed. Love the clarity and forthrightness in everything you write. It is appreciated!Thanks for the great article! Itâ??s sooo helpful and informative.','anku'),('32752','532957847','Others','Great post! Thanks for the information, very helpful. Btw, I discovered your site and blog last week and I???m quite impressed. Love the clarity and forthrightness in everything you write. It is appreciated!Thanks for the great article! It???s sooo helpful and informative.','asd1');

/*Table structure for table `contact` */

DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `name` varchar(50) default NULL,
  `email` varchar(50) default NULL,
  `subject` varchar(30) default NULL,
  `message` blob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contact` */

insert  into `contact`(`name`,`email`,`subject`,`message`) values ('Archit Mishra','archit@gmail.com','Some Questions','Hello,\r\nI am a student of B.Tech .I have some questions.\r\nQ:-----------------------'),('Palak Elhance','palak@gmail.com','Need Help','Need help..Contact me asap :)');

/*Table structure for table `facultyrecord` */

DROP TABLE IF EXISTS `facultyrecord`;

CREATE TABLE `facultyrecord` (
  `name` varchar(50) default NULL,
  `faculty_id` varchar(20) NOT NULL,
  `pass` varchar(15) default NULL,
  `repass` varchar(15) default NULL,
  `email` varchar(20) default NULL,
  `dob` varchar(10) default NULL,
  `branch` varchar(30) default NULL,
  `prinum` varchar(10) default NULL,
  `secnum` varchar(10) default NULL,
  `add` mediumblob,
  `username` varchar(50) default NULL,
  PRIMARY KEY  (`faculty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `facultyrecord` */

insert  into `facultyrecord`(`name`,`faculty_id`,`pass`,`repass`,`email`,`dob`,`branch`,`prinum`,`secnum`,`add`,`username`) values ('Abhishek Jain','688943148','a123','a123','abhishek@gmail.com','2015-07-14','Computer Science Engineering','1234567891','1234567891','Abhishek Jain .....','abhishek');

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `name` varchar(50) default NULL,
  `email` varchar(100) default NULL,
  `subject` varchar(50) default NULL,
  `message` blob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `feedback` */

insert  into `feedback`(`name`,`email`,`subject`,`message`) values ('Anubhav Gupta','anubhavguptacse@gmail.com',':)','All gooooddddd ;) ;)'),('Mohit Sharma','mohitsharma@gmail.com','About lack of Articles','Articles are tooo good but less in number.');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `id` varchar(20) NOT NULL,
  `username` varchar(40) default NULL,
  `password` varchar(40) default NULL,
  `usertype` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`id`,`username`,`password`,`usertype`) values ('195392742','archit','mohit','Student'),('295791316','anku','a123','Alumni'),('532957847','asd1','a1','Others'),('683479271','anubhav','a123','Admin'),('688943148','abhishek','a123','Faculty');

/*Table structure for table `noticecategory` */

DROP TABLE IF EXISTS `noticecategory`;

CREATE TABLE `noticecategory` (
  `category` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `noticecategory` */

insert  into `noticecategory`(`category`) values ('select'),('News');

/*Table structure for table `noticeclass` */

DROP TABLE IF EXISTS `noticeclass`;

CREATE TABLE `noticeclass` (
  `class` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `noticeclass` */

insert  into `noticeclass`(`class`) values ('select'),('Information');

/*Table structure for table `noticeinfo` */

DROP TABLE IF EXISTS `noticeinfo`;

CREATE TABLE `noticeinfo` (
  `no` varchar(20) default NULL,
  `class` varchar(50) default NULL,
  `category` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  `date` varchar(20) default NULL,
  `description` mediumblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `noticeinfo` */

insert  into `noticeinfo`(`no`,`class`,`category`,`type`,`date`,`description`) values ('46411','Information','News','College','2015-07-07','Invitation for Articles\r\nAll the articles will be catagorized under Technical or Non-Technical topics on the basis of contents. Rules for submitting articles are specified as:\r\n* All the articles must have the Title and Author clearly     mentioned.\r\n* Technical articles should be in English strictly.\r\n* Articles will be selected completely based on the innovations and     creativity of the Author.\r\n* The decision of the Editorial team on selection of articles and     publishing them, will be final.'),('42157','Information','News','College','2015-07-09','Cover-Page Design Competition for Student Magazine\r\n\r\nHere is a golden oppurtunity to show-off your talents in creative designs. Take part in the Cover-Page Design Competition for Student Magazine to be released soon. The yearly magazine serves as the media of In-Campus innovations and creatives. It is not only circulated in the NITA campus, but also to several other NITs and IITs. So get your brain and hands together and show your work.\r\n\r\nDesigns are to be submitted within 31st Oct 2010. The theme is \"Creative Technology\". Any type of graphics/photo editing software can be used but the designs are to be submitted strictly in JPG/JPEG format. The best design will be the cover page of the magazine for this year. Decision of the Editorial team will be final.');

/*Table structure for table `noticetype` */

DROP TABLE IF EXISTS `noticetype`;

CREATE TABLE `noticetype` (
  `type` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `noticetype` */

insert  into `noticetype`(`type`) values ('select'),('College');

/*Table structure for table `othersrecord` */

DROP TABLE IF EXISTS `othersrecord`;

CREATE TABLE `othersrecord` (
  `name` varchar(15) NOT NULL,
  `others_id` varchar(20) NOT NULL,
  `pass` varchar(30) default NULL,
  `repass` varchar(30) default NULL,
  `email` varchar(30) default NULL,
  `dob` varchar(10) default NULL,
  `prinum` varchar(10) default NULL,
  `secnum` varchar(10) default NULL,
  `add` mediumblob,
  `username` varchar(50) default NULL,
  PRIMARY KEY  (`others_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `othersrecord` */

insert  into `othersrecord`(`name`,`others_id`,`pass`,`repass`,`email`,`dob`,`prinum`,`secnum`,`add`,`username`) values ('Asd','532957847','a1','a1','asd@gmail.com','2015-07-07','1234568790','1234568790','asdasdasadasd.....','asd1');

/*Table structure for table `studentrecord` */

DROP TABLE IF EXISTS `studentrecord`;

CREATE TABLE `studentrecord` (
  `name` varchar(15) default NULL,
  `student_id` varchar(10) NOT NULL,
  `pass` varchar(20) default NULL,
  `repass` varchar(20) default NULL,
  `email` varchar(30) default NULL,
  `dob` varchar(10) default NULL,
  `branch` varchar(30) default NULL,
  `year` varchar(10) default NULL,
  `prinum` varchar(10) default NULL,
  `secnum` varchar(10) default NULL,
  `add` mediumblob,
  `username` varchar(50) default NULL,
  PRIMARY KEY  (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `studentrecord` */

insert  into `studentrecord`(`name`,`student_id`,`pass`,`repass`,`email`,`dob`,`branch`,`year`,`prinum`,`secnum`,`add`,`username`) values ('Archit Mishra','195392742','a123','a123','archit@gmail.com','2015-07-07','Computer Science Engineering','Fourth','1234567891','1234567891','Archit Mishra','archit');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
