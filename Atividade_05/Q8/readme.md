### 8. Estude o conteúdo do link abaixo e explique como o DIP se aplicaria:
<a href="https://pt.stackoverflow.com/questions/101692/como-funciona-o-padr%C3%A3o-repository"
style="text-decoration: none; color: green; font-weight: bold; font-size: 1em; display: block;">https://pt.stackoverflow.com/questions/101692/como-funciona-o-padr%C3%A3o-repository</a>

> Nesse caso, o DIP poderia ser aplicado de forma a reduzir o acoplamento entre os módulos do sistema. Para isso, poderíamos criar uma interface `UsuarioRepositoryInterface` e fazer com que a classe `UsuarioRepository` implemente essa interface. Dessa forma, o sistema não será impactado caso a classe `UsuarioRepository` seja alterada, pois o sistema depende apenas da interface `UsuarioRepositoryInterface`. </br> </br>

