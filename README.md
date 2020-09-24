# DaryaKurilovich-JWD
C:\Users\Darya\Desktop\ConsoleFinal>mkdir com\epam\jwd\model \\создаем папку проекта, в ней создаем папки  com\epam\jwd\model
C:\Users\Darya\Desktop>move Point.java C:\Users\Darya\Desktop\ConsoleFinal\com\epam\jwd\model \\ перемещаем Point.java в com\epam\jwd\model
Аналогично делаем с Main.java в папку com\epam\jwd\app
C:\Users\Darya\Desktop\ConsoleFinal>mkdir lib \\создаем lib
C:\Users\Darya\Desktop>move slf4j-api-1.7.30.jar C:\Users\Darya\Desktop\ConsoleFinal\lib \\по аналогии с этим переносим в нее все .jar логгера
C:\Users\Darya\Desktop\ConsoleFinal>javac -cp lib/slf4j-api-1.7.30.jar;lib/slf4j-simple-1.7.30.jar com/epam/jwd/model/Point.java com/epam/jwd/app/Main.java \\компилируем
C:\Users\Darya\Desktop\ConsoleFinal> mkdir app \\ создаем app
C:\Users\Darya\Desktop\ConsoleFinal\com\epam\jwd\app>move Main.class C:\Users\Darya\Desktop\ConsoleFinal\app\\перемещаем в app Main.class и так же Poin.class
C:\Users\Darya\Desktop\ConsoleFinal> move C:\Users\Darya\Desktop\ConsoleFinal\app C:\Users\Darya\Desktop \\копируем папки lib и app в другое место

