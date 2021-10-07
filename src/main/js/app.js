'use strict';

const React = require('react'); 
const ReactDOM = require('react-dom');
const axios = require('axios');

const params = {};
const pageSizes = [5,10,20];

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {products: null};
		this.handlePageNumChange = this.handlePageNumChange.bind(this);
		this.handlePageSizeChange = this.handlePageSizeChange.bind(this);
		this.handleSortChanged = this.handleSortChanged.bind(this);
	}

    updateProducts() {
        axios.get(this.getProductUriWithParams(params)).then(
              result => {
                this.setState({
                  isLoaded: true,
                  products: result.data
                });
              },
              error => {
                this.setState({
                  isLoaded: true,
                  error
                });
              }
      );
    }

	componentDidMount() {
		this.updateProducts();
	}

    handlePageNumChange(e) {
        params.page = {
            number: e.target.value,
            size: this.state.products.page.size
        };
        this.updateProducts();
    }

    handlePageSizeChange(e) {
        params.page = {
            number: 0,
            size: e.target.value
        };
        this.updateProducts();
    }

    handleSortChanged(e) {
        params.sort = {
            name: e.name,
            direction: e.direction
        }
        this.updateProducts();
    }

    getProductUriWithParams(parameters) {
        let baseUri = "/api/products";
        let hasPageParams = false;
        let hasSortParams = false;
        let paramsPrefix = "";
        let paramsConjunction = "";

        let pageParams = "";
        let sortParams = "";

        if(parameters.page) {
            const page = parameters.page;
            pageParams = `page=${page.number}&size=${page.size}`;
            hasPageParams = true;
        }

        if(parameters.sort){
            const sort = parameters.sort;
            sortParams = `sort=${sort.name},${sort.direction}`;
            hasSortParams = true;
        }

        if(hasPageParams || hasSortParams) {
            paramsPrefix = "?";
        }

        if(hasPageParams && hasSortParams) {
            paramsConjunction = "&";
        }

        return `${baseUri}${paramsPrefix}${pageParams}${paramsConjunction}${sortParams}`;
    }

	render() {
	    if (!this.state.products) return (null);

	    var pageCountEles = []
        for(var i=0; i<this.state.products.page.totalPages||0; ++i) {
            pageCountEles.push(<option value={i}>{i+1}</option>);
        }

        const pageSizeEles = pageSizes.map(pageNum =>
            <option value={pageNum}>{pageNum}</option>
        );

		return (
		    <>
                <ProductList products={this.state.products._embedded.products || []} onSortChanged={this.handleSortChanged}/>
                <select value={this.state.products.page.number} onChange={this.handlePageNumChange} name="pageCount" id="pageCount">
                    {pageCountEles}
                </select>
                <select value={this.state.products.page.size} onChange={this.handlePageSizeChange} name="pageSizes" id="pageSizes">
                    {pageSizeEles}
                </select>
            </>
		);
	}
}

class ProductList extends React.Component{

    constructor(props) {
        super(props);
        this.onSortChanged = this.onSortChanged.bind(this);
    }

    onSortChanged(e) {
        this.props.onSortChanged(e);
    }

	render() {
		const products = this.props.products.map(product =>
			<Product key={product._links.self.href} product={product}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<td><FilterColumnHeader name="Name" onSortChanged={this.onSortChanged}/></td>
						<td>Description</td>
						<td>Creation Date</td>
						<td>Update Date</td>
						<td>Last Purchased Date</td>
						<td>Action</td>
					</tr>
					{products}
				</tbody>
			</table>
		);
	}
}

class Product extends React.Component{

    onDeleteClick() {
        //todo: add me
    }

	render() {
		return (
			<tr>
				<td>{this.props.product.name}</td>
				<td>{this.props.product.description}</td>
				<td>{this.props.product.creationDate}</td>
				<td>{this.props.product.updateDate}</td>
				<td>{this.props.product.lastPurchasedDate}</td>
				<td><button onClick={this.onDeleteClick}>Delete</button></td>
			</tr>
		);
	}
}

class FilterColumnHeader extends React.Component {

    sort = "Sort";

    constructor(props) {
        super(props);
        this.handleSortClick = this.handleSortClick.bind(this);
    }

    updateSort(sort) {
        if(sort=="asc"){
            return "desc";
        } else {
            return "asc";
        }
    }

    handleSortClick(name) {
        this.sort = this.updateSort(this.sort);
        this.props.onSortChanged({
            name: name,
            direction: this.sort
        });
    }

    render() {
        return (
            <>
                {this.props.name}<button onClick={() => this.handleSortClick(this.props.name)}>{this.sort}</button>
            </>
        );
    }
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
);