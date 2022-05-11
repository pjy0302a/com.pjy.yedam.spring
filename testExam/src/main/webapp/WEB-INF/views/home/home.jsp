<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/tui-example-style.css" />
    <link rel="stylesheet" type="text/css" href="../dist/tui-grid.css" />
</head>
<body>
<h1>시작하는 곳</h1>
<a href="memberSelectList.do">멤버리스트</a>
<a href="memberSelect.do?id=micol@abc.com">멤버상세조회</a>
<a href="memberInsertForm.do">회원가입</a>
<div id="grid"></div>
<script type="text/javascript">
const gridData = [
    {
      name: 'Beautiful Lies',
      artist: 'Birdy',
      release: '2016.03.26',
      type: 'Deluxe',
      genre: 'Pop'
    },
    {
      name: 'X',
      artist: 'Ed Sheeran',
      release: '2014.06.24',
      type: 'Deluxe',
      genre: 'Pop',
      _attributes: {
        disabled: true // A current row is disabled
      }
    },
    {
      name: 'Moves Like Jagger',
      release: '2011.08.08',
      artist: 'Maroon5',
      type: 'Single',
      genre: 'Pop,Rock',
      _attributes: {
        checkDisabled: true // A checkbox is disabled only
      }
    },
    {
      name: 'A Head Full Of Dreams',
      artist: 'Coldplay',
      release: '2015.12.04',
      type: 'Deluxe',
      genre: 'Rock',
      _attributes: {
        checked: true, // A checkbox is already checked while rendering
        className: {
          // Add class name on a row
          row: ['red']
        }
      }
    },
    {
      name: '19',
      artist: 'Adele',
      release: '2008.01.27',
      type: 'EP',
      genre: 'Pop,R&B',
      _attributes: {
        rowSpan: {
          // Merge rows
          artist: 3,
          genre: 2
        }
      }
    },
    {
      name: '21',
      artist: 'Adele',
      release: '2011.01.21',
      type: 'Deluxe',
      genre: 'Pop,R&B'
    },
    {
      name: '25',
      artist: 'Adele',
      release: '2015.11.20',
      type: 'EP',
      genre: 'Pop',
      _attributes: {
        className: {
          // Add class name on each columns
          column: {
            type: ['blue'],
            genre: ['blue']
          }
        }
      }
    }
  ];

  const grid = new tui.Grid({
    el: document.getElementById('grid'),
    data: gridData,
    scrollX: false,
    scrollY: false,
    rowHeaders: ['checkbox'],
    columns: [
      {
        header: 'Name',
        name: 'name'
      },
      {
        header: 'Artist',
        name: 'artist'
      },
      {
        header: 'Type',
        name: 'type'
      },
      {
        header: 'Release',
        name: 'release'
      },
      {
        header: 'Genre',
        name: 'genre'
      }
    ]
  });
</script>
</body>
</html>