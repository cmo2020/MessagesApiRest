# Messages Api Rest

The proyect idea is create a Web Service to allow a company handle  internal messages between employees.

* Functional requirements :

1- User registration : We should have the following data : username , name, last name, identification number, address, zip code city, state, country.

2- User login : Web service have to have the ability to login a registerd user to send and receive messages.

3- Message sending : Web service should allow to send messages to multiple registered users specifiying each recipient as a Primary Receptor (To) , Carbon Copy (CC) or Blind Carbon Copy (BCC). 
User should be logged to send and receive messages. 

4- Messages should have the following data : Subject, Body and Attachments.

5- Message Reception : Web service should allow to receive messages . The user can receive message and catalogue each one with one or more labels.

6- Inbox and Sent : Web service will provide support to query messages in inbox and sent.

7-Label Filtering : Web service must provide tools to filter messages by label. User can add different labels to each message.

8-Each user can create their own personalized labels.

* Non Functional requirements:
1- Pagination : Web service must allow pagination for queries.

2-Performance : Web service must respond each in less than 10 milliseconds

3-Use design patterns and good practices : You must use Design patterns learned in this course.

4-Testing : You must reach at 80% of Unit Testing coverage in your solution.


#ADVICE:
The login authentication in the SecuritConf.Class is made with Basic Authentication by Spring Security, which it means that for every request credentials will be asked.
In order to sing up a new User, it is required a change  in that piece of code, as it has done below. Afert the first user has been singed up it is recommended go back to the initial code.

 @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll().and().formLogin();


    }
