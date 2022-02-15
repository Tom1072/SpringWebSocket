const Header = ( {title} ) => {
  return (
    <div>
        <h1 className='h1'>{title}</h1>
    </div>
  )
}

Header.defaultProps = {
  title: 'Chat Application'
};


export default Header
